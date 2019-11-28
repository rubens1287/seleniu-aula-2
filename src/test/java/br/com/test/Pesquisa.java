package br.com.test;

import br.com.utils.StringUtils;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.Normalizer;
import java.util.Locale;

public class Pesquisa extends Base{


    @Test
    public void pesquisarNoGoogle(){

        /*

         */
        driver.get("https://www.google.com.br/");

        /*
            envia texto para o elemento mapeado
         */
        driver.findElement(By.name("q")).sendKeys("QA Wolf");


        /*
            submete formulario
         */
        driver.findElement(By.name("q")).submit();

        /*
            Aguarda elemento até ele ser clicavél
         */
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.
                        elementToBeClickable(By.xpath("//span[contains(text(),'QA WOLF | Qualidade de Software com Rubens Lobo')]")));


        /*
        Pega o texto do elemento da tela
         */
        String texto = driver.findElement(By.xpath("//span[contains(text(),'QA WOLF | Qualidade de Software com Rubens Lobo')]")).getText();

        /*
        validação com Junit
         */
        Assert.assertEquals("QA WOLF | Qualidade de Software com Rubens Lobo",texto);

        /*
        desafio dado: cadastra um novo usuário na aplicação seu-barriga
         */

    }

    @Test
    public void cadastrarUsuario() throws InterruptedException {

        driver.get("https://seubarriga.wcaquino.me/login");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[contains(text(),'Novo usuário?')]")).click();

        Thread.sleep(1000);

        Faker faker = new Faker(new Locale("pt-BR"));

        driver.findElement(By.id("nome")).sendKeys("Angelica Turquesa");
        driver.findElement(By.id("email")).sendKeys(StringUtils.unaccent(faker.name().name().replace(" ","") + "@gft.com"));
        driver.findElement(By.id("senha")).sendKeys("123@nath");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Cadastrar']")).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Usuário inserido com sucesso')]")));
    }

}

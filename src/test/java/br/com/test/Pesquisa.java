package br.com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pesquisa {

    WebDriver driver;

    @Before
    public void setup(){
        /*
        imforma onde está o driver chromedriver para o selenium
         */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        /*
           cria navegador do tipo chrome
         */
        driver = new ChromeDriver();
        /*
        maximiza a tela
         */
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        /*
        fechar navegador
         */
        driver.close();
    }

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


}

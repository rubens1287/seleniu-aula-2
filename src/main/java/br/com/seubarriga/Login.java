package br.com.seubarriga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    private WebDriver driver;
    private By txtEmail = By.id("email");
    private By txtSenha = By.id("senha");
    private By btnEntrar = By.xpath("//button");


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Aguarda o carregamento da pagina de Login
     */
    public void AguardarTelaLogin(){
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(txtEmail));
    }

    /**
     * Metodo que executa login na aplicação
     *
     * @param email - valor referente a um email de um usuálrio
     * @param senha - valor referente a senha do usuário
     */
    public void logar(String email, String senha){
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtSenha).sendKeys(senha);
        driver.findElement(btnEntrar).click();
    }
}

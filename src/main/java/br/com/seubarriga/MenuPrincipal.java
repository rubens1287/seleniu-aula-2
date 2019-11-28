package br.com.seubarriga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipal {

    WebDriver driver;
    private By lnkSair = By.linkText("Sair");

    public MenuPrincipal(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Aguarda tela do Menu Principal aparecer
     */
    public void aguardarTelaMenuPrincipal(){
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(lnkSair));
    }
}

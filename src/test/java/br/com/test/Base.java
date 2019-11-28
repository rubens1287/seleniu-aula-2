package br.com.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static WebDriver driver;

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
}

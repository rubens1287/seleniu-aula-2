package br.com.test;

import br.com.seubarriga.Login;
import br.com.seubarriga.MenuPrincipal;
import org.junit.Test;

public class LoginTest extends Base {


    @Test
    public void LoginComSucesso(){
        Login login = new Login(driver);
        driver.get("https://seubarriga.wcaquino.me/");
        login.AguardarTelaLogin();
        login.logar("teste123@teste.com.br","1234");
        MenuPrincipal menuPrincipal =  new MenuPrincipal(driver);
        menuPrincipal.aguardarTelaMenuPrincipal();
    }

}

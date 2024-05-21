package ejercicio2.conPO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage {
    WebDriver driver;
    WebElement cajaUsuario;
    WebElement cajaContrasena;

    WebElement btnLogin;

    WebElement errorMsg;
    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
         cajaUsuario = driver.findElement(By.name("login[username]"));
         cajaContrasena = driver.findElement(By.name("login[password]"));
         btnLogin = driver.findElement(By.id("send2"));
    }

    public void loginOk()
    {
        cajaUsuario.sendKeys("pausicseries@gmail.com");
        cajaContrasena.sendKeys("123456");
        btnLogin.click();

    }

    public void loginError()
    {
        cajaUsuario.sendKeys("estamal@gmail.com");
        cajaContrasena.sendKeys("asdfaeasdfae");
        btnLogin.click();
        errorMsg = driver.findElement(By.className("error-msg"));
        Assert.assertEquals("Invalid login or password.",errorMsg.getText());
    }

}

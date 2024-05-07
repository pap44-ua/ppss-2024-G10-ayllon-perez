package Ejercicio1.sinPageObject;
import org.junit.*;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

public class TestCreateAccount {

    WebDriver driver;

    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");

    }

    @Tag("OnlyOnce")
    @Test
    public void S1_scenario_createAccount_should_create_new_account_in_the_demo_store_when_this_account_does_not_exist()
    {
        //Comprobamos el titulo
        Assert.assertEquals("Madison Island", driver.getTitle());

        //WebElement Account
        WebElement acoount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        acoount.click();

        //WebElement LogIn
        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        //Comprobamos el titulo
        Assert.assertEquals("Customer Login", driver.getTitle());

        //WebElement CreateAccount
        WebElement createAccount = driver.findElement(By.cssSelector("#login-form > div > div.col-1.new-users > div.buttons-set > a"));
        createAccount.click();

        //Comprobamos el titulo
        Assert.assertEquals("Create New Customer Account", driver.getTitle());

        //Rellenamos las casillas
        WebElement nombre = driver.findElement(By.cssSelector("#firstname"));
        nombre.sendKeys("Paula");
        WebElement apellido = driver.findElement(By.cssSelector("#lastname"));
        apellido.sendKeys("Ayllon");
        WebElement email = driver.findElement(By.cssSelector("#email_address"));
        email.sendKeys("pap44@gcloud.ua.es");
        WebElement contraseña = driver.findElement(By.cssSelector("#password"));
        contraseña.sendKeys("123456");

        WebElement createAcc = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button"));
        createAcc.click();

        WebElement errorRepetir = driver.findElement(By.cssSelector("#advice-required-entry-confirmation"));
        Assert.assertEquals("This is a required field.", errorRepetir.getText());

        WebElement repetirContra = driver.findElement(By.cssSelector("#confirmation"));
        repetirContra.sendKeys("123456");

        createAcc.click();

        driver.navigate().back();

        Assert.assertEquals("My Account", driver.getTitle());




    }

    @AfterEach
    void end()
    {
        driver.quit();
    }

}

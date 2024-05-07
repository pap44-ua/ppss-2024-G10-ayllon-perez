package Ejercicio1.sinPageObject;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestLogin {

    WebDriver driver;

    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");

    }

    @Test
    public void S2_scenario_loginOK_should_login_with_success_when_user_account_exists() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("pausicseries@gmail.com");

        WebElement logIn = driver.findElement(By.cssSelector("#send2"));
        logIn.click();

        WebElement error = driver.findElement(By.cssSelector("#advice-required-entry-pass"));
        Assert.assertEquals("This is a required field.", error.getText());

        WebElement contrasena = driver.findElement(By.cssSelector("#pass"));
        contrasena.sendKeys("123456");

        logIn.click();

        //Thread.sleep(20);

        Assert.assertEquals("My Account", driver.getTitle());



    }
    @Test
    public void S3_scenario_loginFailed_should_fail_when_user_account_not_exists()
    {
        //Comprobamos el titulo
        Assert.assertEquals("Madison Island", driver.getTitle());

        //WebElement Account
        WebElement acoount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        acoount.click();

        //WebElement LogIn
        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Comprobamos el titulo
        Assert.assertEquals("Customer Login", driver.getTitle());

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("pausicseries@gmail.com");

        WebElement logIn = driver.findElement(By.cssSelector("#send2"));


        WebElement contrasena = driver.findElement(By.cssSelector("#pass"));
        contrasena.sendKeys("12345678");

        logIn.click();

        WebElement error = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertEquals("Invalid login or password.", error.getText());




    }

    @AfterEach
    void end()
    {
        driver.quit();
    }

}

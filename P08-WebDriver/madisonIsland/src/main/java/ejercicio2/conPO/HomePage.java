package ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://demo-store.seleniumacademy.com/");
    }

    public void navigateToLogin() {
        WebElement accountMenu = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        accountMenu.click();
        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }


}

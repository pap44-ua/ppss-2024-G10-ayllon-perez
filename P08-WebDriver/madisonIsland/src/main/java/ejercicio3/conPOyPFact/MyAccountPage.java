package ejercicio3.conPOyPFact;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    WebDriver driver;
    @FindBy(css = "#nav > ol > li.level0.nav-3.parent > a")
    WebElement accesorio;
    @FindBy(css = "#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-3 > a")
    WebElement shoe;
    Actions builder;

    public MyAccountPage(WebDriver driver) {

        driver.get("http://demo-store.seleniumacademy.com/customer/account/");
        this.driver = driver;

        builder = new Actions(driver);
    }

    public void moveToShoes()
    {
        Assert.assertEquals("My Account", this.getTitle());
        builder.moveToElement(accesorio);
        builder.perform();
        builder.moveToElement(shoe);
        builder.perform();
        shoe.click();

    }

    public String getTitle() {
        return driver.getTitle();
    }
}

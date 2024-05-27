package ejercicio3.conPOyPFact;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ShoesPage {


    WebDriver driver;
    Actions builder;

    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > ul > li > ul > li > span")
    WebElement msg_borrado;

    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div > div.block-content > div > a")
    WebElement btnClear;

    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(5) > div > div.actions > ul > li:nth-child(2) > a")
    WebElement wingtipShoe;
    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(6) > div > div.actions > ul > li:nth-child(2) > a")
    WebElement suedeShoe;

    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div > div.block-content > div > button")
    WebElement btnCompare;






    public ShoesPage(WebDriver driver)
    {
        this.driver = driver;
        builder = new Actions(driver);
        //wingtipShoe = driver.findElement(By.cssSelector(""));
        //suedeShoe.findElement(By.cssSelector(""));
        //btnCompare.findElement(By.cssSelector(""));
    }

    public void selectShoeToCompare(int number) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch (number) {
            case 5:

                jse.executeScript("arguments[0].scrollIntoView();", wingtipShoe);
                wingtipShoe.click();
                break;
            case 6:
                jse.executeScript("arguments[0].scrollIntoView();", suedeShoe);
                suedeShoe.click();
                break;
        }
    }

    public Products pageShoe()
    {
        Assert.assertEquals("Shoes - Accessories", this.getTitle());

        selectShoeToCompare(5);
        selectShoeToCompare(6);

       btnCompare.click();

        Set<String> setIds = driver.getWindowHandles();
        String[] handleIds = setIds.toArray(new String[setIds.size()]);
        Products products = PageFactory.initElements(driver, Products.class);
        products.setMyHandleIDFrom(handleIds[0]);
        driver.switchTo().window(handleIds[1]);
        return products;


    }

    public void limpiarCompare()
    {
        Assert.assertEquals("Shoes - Accessories", this.getTitle());
        btnClear.click();
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        Assert.assertEquals("Do you like to remove all products from your comparison?", mensaje);
        alert.accept();
        Assert.assertEquals("The comparison list was cleared.", msg_borrado.getText());



    }
    public String getTitle() {
        return driver.getTitle();
    }



}

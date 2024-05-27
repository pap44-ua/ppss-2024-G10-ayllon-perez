package ejercicio3.conPOyPFact;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.Set;

public class Products {

    WebDriver driver;
    String myHandleId;
    String myHandleIdFROM;

    @FindBy(css = "body > div > div.buttons-set > button")
    WebElement btnCerrar;
    Set<String> setIds;
    String[] handleIds;


    public Products(WebDriver driver)
    {
        this.driver = driver;

    }

    public ShoesPage compareProducts()
    {
        Assert.assertEquals("Products Comparison List", this.getTitle() );
        btnCerrar.click();
        driver.switchTo().window(myHandleIdFROM);
        return PageFactory.initElements(driver, ShoesPage.class);

    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setMyHandleIDFrom(String handleId) {
        this.myHandleIdFROM = handleId;
    }
}

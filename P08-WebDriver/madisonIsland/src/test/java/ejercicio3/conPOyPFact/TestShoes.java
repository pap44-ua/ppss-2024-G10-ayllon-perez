package ejercicio3.conPOyPFact;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class TestShoes {

    private WebDriver driver;

    public ShoesPage shoesPage;
    public Products products;
    public MyAccountPage myAccountPage;


    @BeforeAll
    public static void uwu()
    {
        Cookies.storeCookiesToFile("pausicseries@gmail.com", "123456" );
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions co = new ChromeOptions();
        co.setBrowserVersion("119");
        driver = new ChromeDriver(co);
        Cookies.loadCookiesFromFile(driver);
        myAccountPage= PageFactory.initElements(driver, MyAccountPage.class);
    }

    @Test
    public void compareShoes() {
        myAccountPage.moveToShoes();
        shoesPage = new ShoesPage(driver);
        shoesPage.pageShoe();
        products = new Products(driver);
        products.compareProducts();
        shoesPage.limpiarCompare();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

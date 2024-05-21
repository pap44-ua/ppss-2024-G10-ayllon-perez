package ejercicio2.conPO;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin2 {
    WebDriver driver;
    HomePage home;
    CustomerLoginPage loginPage;
    MyAccountPage accountPage;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        home = new HomePage(driver);
    }

    @Test
    public void S4_scenario_PO_loginOK_should_login_with_success_when_user_account_exists() {
        Assert.assertEquals("Madison Island", home.getTitle());
        home.navigateToLogin();
        Assert.assertEquals("Customer Login", home.getTitle());
        loginPage = new CustomerLoginPage(driver);
        loginPage.loginOk();

    }

    @Test
    public void S5_scenario_PO_loginFailed_should_fail_when_user_account_not_exists() {
        Assert.assertEquals("Madison Island", home.getTitle());
        home.navigateToLogin();
        Assert.assertEquals("Customer Login", home.getTitle());
        loginPage = new CustomerLoginPage(driver);
        loginPage.loginError();
    }

    @AfterEach
    void end() {
        driver.quit();
    }
}

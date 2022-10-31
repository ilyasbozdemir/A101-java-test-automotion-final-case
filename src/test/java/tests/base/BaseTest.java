package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.hepsiburada.com.*;
import utilities.Driver;

import java.time.Duration;

public class BaseTest {
    protected  WebDriver driver ;
    protected  WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginOrSignUpPage loginOrSignUpPage;
    protected BasketPage basketPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;


    @BeforeTest
    public void beforeMethod() {
        driver = Driver.getDriver();
        homePage= new HomePage(driver);
        loginOrSignUpPage= new LoginOrSignUpPage(driver);
        basketPage= new BasketPage(driver);
        productsPage= new ProductsPage(driver);
        productDetailsPage=new ProductDetailsPage(driver);

        driverWait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    @AfterTest
    public void afterMethod() {
        Driver.closeDriver();
    }
}

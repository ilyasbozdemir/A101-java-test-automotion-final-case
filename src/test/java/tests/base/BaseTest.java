package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.hepsiburada.com.*;
import tests.Abstract.Testable;
import utilities.Driver;

import java.time.Duration;

public class BaseTest implements Testable {
    protected  WebDriver driver ;
    protected  WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginOrSignUpPage loginOrSignUpPage;
    protected BasketPage basketPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;

    @AfterTest
    @Override
    public void afterMethod() {
        Driver.closeDriver();
    }
    @BeforeTest
    @Override
    public void beforeMethod() {

        driver = Driver.getDriver();
        homePage= new HomePage(driver);
        loginOrSignUpPage= new LoginOrSignUpPage(driver);
        basketPage= new BasketPage(driver);
        productsPage= new ProductsPage(driver);
        productDetailsPage=new ProductDetailsPage(driver);
        driverWait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }


}

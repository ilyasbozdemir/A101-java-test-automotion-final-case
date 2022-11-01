package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HepsiBurada.*;
import utilities.Driver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver ;
    WebDriverWait driverWait;
   protected HomePage homePage;
    protected LoginOrSignUpPage loginOrSignUpPage;
    protected BasketPage basketPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    @BeforeTest
    public void beforeMethod() {
        driver=Driver.getDriver();
        homePage= new pages.HepsiBurada.HomePage(driver);
        loginOrSignUpPage= new pages.HepsiBurada.LoginOrSignUpPage(driver);
        basketPage= new pages.HepsiBurada.BasketPage(driver);
        productsPage= new pages.HepsiBurada.ProductsPage(driver);
        productDetailsPage=new pages.HepsiBurada.ProductDetailsPage(driver);

        driverWait= new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    public void delay(long seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    @AfterTest
    public void afterMethod() {
        //Driver.closeDriver();
    }
}

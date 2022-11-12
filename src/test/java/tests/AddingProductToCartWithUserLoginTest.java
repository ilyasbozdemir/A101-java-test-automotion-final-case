package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.awt.*;
import java.time.Duration;

@Test
public class AddingProductToCartWithUserLoginTest extends BaseTest {
    @Test(priority = 1, description = "Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1() throws AWTException, InterruptedException {

        driver.get(homePage.getUrl);
        homePage.implicitlyWait(Duration.ofSeconds(10));
        homePage.acceptCookies();
        homePage.getTitle = driver.getTitle();
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle, "Not on home page!");

    }

    @Test(priority = 2, dependsOnMethods = "step1", description = "Kullanıcı giriş işlemi yapılır.")
    public void step2() throws InterruptedException {
        homePage.gotoLoginOrSignUp();
        String emailAddress = PropertiesFile.getProperties(PagePath.configurationPath, "mail");
        ;
        String password = PropertiesFile.getProperties(PagePath.configurationPath, "passw");
        ;

        loginOrSignUpPage.LoginWith(emailAddress, password);

        loginOrSignUpPage.expectedTitle = "Üye Giriş Sayfası & Üye Ol - Hepsiburada";
        loginOrSignUpPage.getTitle = driver.getTitle();
        Assert.assertEquals(loginOrSignUpPage.getTitle, loginOrSignUpPage.expectedTitle, "Not on login page!");
    }

    @Test(priority = 3, dependsOnMethods = "step2", description = "Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır")
    public void step3() {
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        homePage.getTitle = driver.getTitle();

        Assert.assertTrue(new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.titleIs(homePage.expectedTitle)));
    }

    @Test(priority = 4, dependsOnMethods = "step3", description = "Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void step4() {
        homePage.searchProduct("pil");
    }

    @Test(priority = 5, dependsOnMethods = "step4", description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step5() {
        productsPage.selectProduct(0);
        Assert.assertFalse(productsPage.selectedProduct == null, "The selected product is empty");
    }

    @Test(priority = 6, dependsOnMethods = "step4", description = "Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    private void step6() {
        productsPage.productsAddToCart();
        Assert.assertTrue(productsPage.productsBeenAddedToTheCart(), "Card is empty");
    }

    @Test(priority = 7, dependsOnMethods = "step6", description = "Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.")
    private void step7() {
        boolean state = basketPage.goToCartVerifyCart();

        if (state) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('Congratulations, your test was successful.');");
        }
        Assert.assertTrue(state, "Congratulations, your test was successful.");
    }
}

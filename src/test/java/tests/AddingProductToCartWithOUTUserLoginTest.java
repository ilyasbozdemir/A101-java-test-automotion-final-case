package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddingProductToCartWithOUTUserLoginTest extends BaseTest {
    @Test(priority = 1, description = "Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1() {
        driver.get(homePage.getUrl);
        homePage.implicitlyWait(Duration.ofSeconds(10));
        homePage.acceptCookies();
        homePage.getTitle = driver.getTitle();
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle, "Not on home page!");
    }


    @Test(priority = 4, description = "Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void step2() {
        homePage.searchProduct("pil");
    }

    @Test(priority = 5, description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step3() {
        productsPage.selectProduct(0);
        Assert.assertFalse(productsPage.selectedProduct == null, "The selected product is empty");
    }

    @Test(priority = 6, description = "Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    private void step4() {
        productsPage.productsAddToCart();
        Assert.assertFalse(productsPage.productsBeenAddedToTheCart(), "Card is empty");
    }

    @Test(priority = 7, description = "Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.")
    private void step5() {

        boolean state = basketPage.goToCartVerifyCart();

        if (state) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('Congratulations, your test was successful.');");
        }

        Assert.assertTrue(state, "Congratulations, your test was successful.");
    }
}

package tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Test(priority = 0,groups = "Test1Group")
public class AddingProductToCartWithUserLogin extends BaseTest{

    @Test(priority = 1,description = "Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1() throws InterruptedException{
        driver.get(homePage.getUrl);
        delay(3);
        homePage.acceptCookies();
        homePage.getTitle = driver.getTitle();
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle,"Not on home page!");
    }

    @Test(dependsOnMethods = "step1",description = "Kullanıcı giriş işlemi yapılır.")
    public void step2() {
        homePage.gotoLoginOrSignUp();
        String emailAddress= PropertiesFile.getProperties(PagePath.configurationPath,"mail");;
        String password= PropertiesFile.getProperties(PagePath.configurationPath,"passw");;

        loginOrSignUpPage.Login(emailAddress,password);
        loginOrSignUpPage.expectedTitle = "Üye Giriş Sayfası & Üye Ol - Hepsiburada";
        loginOrSignUpPage.getTitle = driver.getTitle();
        Assert.assertEquals(loginOrSignUpPage.getTitle, loginOrSignUpPage.expectedTitle,"Not on login page!");
    }
    @Test(dependsOnMethods = "step2",description = "Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır")
    public void step3() {
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        homePage.getTitle = driver.getTitle();
        Assert.assertTrue(new WebDriverWait(driver,Duration.ofMillis(10000))
                .until(ExpectedConditions.titleIs(homePage.expectedTitle)));
    }
    @Test(dependsOnMethods = "step3",description = "Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void step4(){
        homePage.searchProduct("makarna");
    }
    @Test(dependsOnMethods = "step4",description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step5() throws InterruptedException {
        productsPage.selectProduct(0);
    }
    @Test(dependsOnMethods = "step5",description = "Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    private void step6() throws InterruptedException{
        productsPage.chooseTwoDifferentProductsAddToCart();
    }
    @Test(dependsOnMethods = "step6",description = "Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.")
    private void step7(){
        //basketPage.verifyCart();
    }
}

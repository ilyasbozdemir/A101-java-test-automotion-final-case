package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hepsiburada.com.HomePage;
import tests.base.BaseTest;
import utilities.PagePath;
import utilities.PropertiesFile;


public class Test1 extends BaseTest {


    @Test(priority = 1,description = "Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1(){

        driver.get(homePage.getUrl);
        homePage.acceptCookies();
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle,"Not on home page!");
    }

    @Test(dependsOnMethods = "step1",description = "Kullanıcı giriş işlemi yapılır.")
    public void step2(){
        homePage.gotoLoginOrSignUp();
        String emailAddress= PropertiesFile.getProperties(PagePath.configurationPath,"mail");;
        String password= PropertiesFile.getProperties(PagePath.configurationPath,"passw");;

        loginOrSignUpPage.Login(emailAddress,password);
        Assert.assertEquals(loginOrSignUpPage.getTitle,loginOrSignUpPage.expectedTitle,"Not on login page!");

    }
    @Test(dependsOnMethods = "step2",description = "Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır")
    public void step3(){

        driverWait.until(ExpectedConditions.titleIs(homePage.expectedTitle));
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle,"Not on login page!");

    }
    @Test(dependsOnMethods = "step3",description = "Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void step4() {
        homePage.searchProduct("makarna");
    }
    @Test(dependsOnMethods = "step4",description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step5(){
        productsPage.selectProduct(0);
    }
    @Test(dependsOnMethods = "step5",description = "Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    private void step6() throws InterruptedException{
        productsPage.chooseTwoDifferentProductsAddToCart();
    }
    @Test(dependsOnMethods = "step6",description = "Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.")
    private void step7(){
        basketPage.verifyCart();
    }
}

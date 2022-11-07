package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingProductToCartWithOUTUserLoginTest extends BaseTest{
//aslında burda xml dosyasında farklı grup vweya farklı test adında
    //ilgili methdoları cıkarma ekleme ile tek yerden yapılırdı
    @Test(priority = 1,description = "Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1()  {
        driver.get(homePage.getUrl);
        delay(3);
        homePage.acceptCookies();
        homePage.getTitle = driver.getTitle();
        homePage.expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(homePage.getTitle, homePage.expectedTitle,"Not on home page!");
    }



   @Test(priority = 4,description = "Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void step2(){
       homePage.searchProduct("pil");
    }

    @Test(priority = 5,description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step3() {
        productsPage.selectProduct(0);
    }

    @Test(priority = 6,description = "Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    private void step4()  {
        productsPage.productsAddToCart();
    }

    @Test(priority = 7,description = "Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.")
    private void step5() {
        basketPage.goToCartVerifyCart();
    }
}

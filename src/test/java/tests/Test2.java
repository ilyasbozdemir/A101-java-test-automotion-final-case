package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;


public class Test2 extends BaseTest {

    @Test(priority =0,description ="Kullanıcı Hepsiburada.com sitesini ziyaret eder.")
    public void step1(){

    }
    @Test(priority = 1,dependsOnMethods = "step2",description = "Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.")
    public void step2(){

    }
    @Test(priority = 2,dependsOnMethods = "step2",description ="Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.")
    public void step3() throws InterruptedException {

    }
    @Test(priority = 3,dependsOnMethods = "step2",description ="Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ svayfasında doğrulanmalıdır.")
    public void step4(){

    }
}

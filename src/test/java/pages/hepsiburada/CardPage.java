package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;

import java.awt.*;

public class CardPage extends BasePage{
    public CardPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="";
    }
    public By gotoCartLocator =
            getPropertiesToXPath(PagePath.basketPagePath,"gotoCartLocator");
    public By BasketEmptyLocator =
            getPropertiesToXPath(PagePath.basketPagePath,"BasketEmptyLocator");

    public By  basketItemCount=
            getPropertiesToXPath(PagePath.basketPagePath,"basketItemCount");

    public By productName =new By.ByClassName("product_name_3Lh3t");
    //
    public By merchantName =new By.ByClassName("merchantLink_2Ii8s");
    //
    public By containerLocator =new By.ByClassName("container_HX1zs");//product count container

    public WebElement productQuantity;
    //

    public void goToCartVerifyCart()  {
        driver.get("https://checkout.hepsiburada.com/sepetim");

        for(int i=0;i<findAll(productName).size();i++){
            if(i==0){
                System.out.println(firstProductName+" -p1 "+ findAll(productName).get(i).getText());
                System.out.println(firstMerchantName+" -p1 "+ findAll(merchantName).get(i).getText());
            }
            else{
                System.out.println(secondProductName+" -p2 "+ findAll(productName).get(i).getText());
                System.out.println(secondMerchantName+" -m2 "+ findAll(merchantName).get(i).getText());
            }
        }
        /*
        for (WebElement element:findAll(productName)){
            System.out.println(element.getText());
        }
        for (WebElement element:findAll(merchantName)){
            System.out.println(element.getText());
        }
        */
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('Congratulations, your test was successful.');");

    }
    private boolean isTheBasketEmpty(By locator){
        return find(locator).getText() == "Sepetin şu an boş";
    }


}

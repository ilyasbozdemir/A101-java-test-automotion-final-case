package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;
import utilities.PropertiesFile;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver){
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

        /*
        String firstProductName=
        PropertiesFile.getProperties(PagePath.basketPagePath,"firstProductName");
        String firstMerchantName=
        PropertiesFile.getProperties(PagePath.basketPagePath,"firstMerchantName");
            String secondProductName=
             PropertiesFile.getProperties(PagePath.basketPagePath,"secondProductName");
             String secondMerchantName=
              PropertiesFile.getProperties(PagePath.basketPagePath,"secondMerchantName");
*/

       /* for (WebElement element:findAll(merchantName)){
            System.out.println(element.getText());
        }*/



    }
    // productQuantity = find(containerLocator).findElement(By.name("quantity"));
    private boolean isTheBasketEmpty(By locator){
        return find(locator).getText() == "Sepetin şu an boş";
    }


}

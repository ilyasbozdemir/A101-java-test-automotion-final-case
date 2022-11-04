package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.util.*;

public class ProductDetailsPage  extends BasePage{

    public  By addToCardButtonLocator =
            getPropertiesToXPath(PagePath.productDetailsPagePath,"addToCardButtonLocator");
    public By merchantTabTriggerLocator=
            getPropertiesToXPath(PagePath.productDetailsPagePath,"merchantTabTriggerLocator");
    public By merchantListLocator= new By.ByClassName("merchant-list-item");
    public By productName = By.xpath("//*[@id=\"detail-container\"]/div/header/span");
    public By merchantName = By.xpath("//*[@id=\"detail-container\"]/div/span/a");
    public int merchantCount = 0;
    public By merchantCountLocator=By.xpath("//*[@id=\"merchantTabTrigger\"]/a/span/span");

    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;

    }

    public List<WebElement> merchantList(){
        return super.findAll(merchantListLocator);
    }
    public String getProductName(){
        return getText(productName);
    }
    public String getMerchantName(){
        return  getText(merchantName);
    }
    int i=0;
    public void addToCard(){
        addToCardData();
        i++;
        click(addToCardButtonLocator);
    }
    public void addToCardData(){

        /*

        if (i==0){
            PropertiesFile.setProperties(PagePath.basketPagePath,
                    "firstProductName",getProductName(),"setData");
            PropertiesFile.setProperties(PagePath.basketPagePath,
                    "firstMerchantName",getMerchantName(),"setData");
        }
        else{
            PropertiesFile.setProperties(PagePath.basketPagePath,
                    "secondProductName",getProductName(),"setData");
            PropertiesFile.setProperties(PagePath.basketPagePath,
                    "secondMerchantName",getMerchantName(),"setData");
        }
        */
    }

}

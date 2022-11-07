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
    public By merchantNameLocator=  By.xpath("/td[2]/div/a[2]/span");
    //merchantListLocator içinde ki xpath

    public By productName = By.xpath("//*[@id=\"detail-container\"]/div/header/span");

    public WebElement merchantName;
    public int merchantCount = 0;
    public By merchantCountLocator=By.xpath("//*[@id=\"merchantTabTrigger\"]/a/span/span");

    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;
    }

    public List<WebElement> merchantList(){
        return super.findAll(merchantListLocator);
    }
    public String getProductName(){

        return find(productName).getAttribute("innerText").trim();
    }
    public String getMerchantName(){
        return merchantName.getAttribute("innerText").trim();
    }

    public void addToCard(){
        click(addToCardButtonLocator);
    }
}

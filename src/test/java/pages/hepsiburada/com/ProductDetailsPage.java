package pages.hepsiburada.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PagePath;

public class ProductDetailsPage  extends BasePage{
    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="https://www.hepsiburada.com/";
    }
    By addToCardSmallLocators =  getPropertiesToXPath(PagePath.productDetailsPagePath,"addToCardSmallLocators");
    By addToCardLocator =  getPropertiesToXPath(PagePath.productDetailsPagePath,"addToCardSmallLocator");

}

package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PagePath;

public class ProductDetailsPage  extends BasePage{
    public By addToCardSmallFirstButtonLocator =
            getPropertiesToXPath(PagePath.productDetailsPagePath,"addToCardSmallFirstButtonLocator");
    public  By addToCardSmallSecondButtonLocator =
            getPropertiesToXPath(PagePath.productDetailsPagePath,"addToCardSmallSecondButtonLocator");
    public By merchantTabTriggerLocator=
            getPropertiesToXPath(PagePath.productDetailsPagePath,"merchantTabTriggerLocator");

    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="";
    }
}

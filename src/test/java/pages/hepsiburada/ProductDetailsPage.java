package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PagePath;

public class ProductDetailsPage  extends BasePage{
    public By addToCardSmallFirstButtonLocator =By.xpath("//html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/form/button");
    public  By addToCardSmallSecondButtonLocator =By.xpath("//html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[3]/div/form/button");
    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="";
    }
}

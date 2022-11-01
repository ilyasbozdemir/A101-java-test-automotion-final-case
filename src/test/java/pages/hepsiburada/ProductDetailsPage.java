package pages.HepsiBurada;

import org.openqa.selenium.WebDriver;

public class ProductDetailsPage  extends BasePage{
    public ProductDetailsPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="https://www.hepsiburada.com/";
    }
}

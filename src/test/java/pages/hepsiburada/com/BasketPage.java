package pages.hepsiburada.com;

import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="https://www.hepsiburada.com/";
    }

    public void verifyCart() {

    }
}

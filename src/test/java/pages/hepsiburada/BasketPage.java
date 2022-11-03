package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PagePath;

import java.time.Duration;

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

    public void verifyCart() {
        click(gotoCartLocator);
        if(isTheBasketEmpty(BasketEmptyLocator) && find(basketItemCount).getText() == "2" ){

        }
    }
    private boolean isTheBasketEmpty(By locator){
        return find(locator).getText() != "Sepetin şu an boş";
    }
}

package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="";
    }
    public By cartItemCountLocator = By.xpath("//*[@id=\"cartItemCount\"]");

    public void verifyCart() {
        //burda göremiyor sepette ki sayıyı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itemCountLocator = wait
                .until(ExpectedConditions.visibilityOfElementLocated(cartItemCountLocator));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(20,0)", itemCountLocator);

        System.out.println(itemCountLocator.getText());
    }
}

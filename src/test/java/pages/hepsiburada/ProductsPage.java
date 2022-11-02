package pages.HepsiBurada;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PagePath;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ProductsPage extends BasePage{
    By productNameLocator =  getPropertiesToXPath(PagePath.productsPagePath,"productNameLocator");

    ProductDetailsPage productDetailsPage;
    public WebElement selectedProduct;

    public ProductsPage(WebDriver driver){
        super.driver=driver;
    }
    public List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
    public void selectProduct(int index) throws InterruptedException {
        selectedProduct =  getAllProducts().get(index);
        scrollIntoElement(selectedProduct);
        hover(selectedProduct);
    }
    public void chooseTwoDifferentProductsAddToCart() throws InterruptedException {

        productDetailsPage = new ProductDetailsPage(driver);
        String firstWindow = driver.getWindowHandle();

        selectedProduct.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!firstWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                //productDetails page:

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement addToCardSmallFirstButtonLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsPage.addToCardSmallFirstButtonLocator));

                scrollIntoElement(addToCardSmallFirstButtonLocator);
                addToCardSmallFirstButtonLocator.click();

                Thread.sleep(1000);
                WebElement addToCardSecondFirstButtonLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsPage.addToCardSmallFirstButtonLocator));

                scrollIntoElement(addToCardSecondFirstButtonLocator);
                addToCardSecondFirstButtonLocator.click();

                Thread.sleep(1000);

                driver.close();
                break;

            }
        }
        Thread.sleep(3000);
        driver.switchTo().window(firstWindow);
    }


}

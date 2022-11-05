package pages.HepsiBurada;
import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PagePath;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
public class ProductsPage extends BasePage{
    public By productNameLocator =  getPropertiesToXPath(PagePath.productsPagePath,"productNameLocator");
    ProductDetailsPage productDetailsPage;
    CardPage basketPage;
    public WebElement selectedProduct;

    public ProductsPage(WebDriver driver){
        super.driver=driver;
    }
    public List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void selectProduct(int index)  {

        selectedProduct =  getAllProducts().get(index);
        scrollIntoElement(selectedProduct);
        hover(selectedProduct);
    }

    public void productsAddToCart() throws InterruptedException {

        productDetailsPage = new ProductDetailsPage(driver);
        basketPage= new CardPage(driver);
        String firstWindow = driver.getWindowHandle();
        selectedProduct.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!firstWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);

                scrollIntoElementAndClick(productDetailsPage.merchantTabTriggerLocator);
                productDetailsPage.merchantCount = Integer
                        .parseInt(find(productDetailsPage.merchantCountLocator).getText());
                String title = getTitle();
                if(productDetailsPage.merchantCount >= 2){
                    for(int i=0;i<2;i++){

                        WebElement merchantElement = productDetailsPage.merchantList().get(i);

                        merchantElement.click();

                        if(i==0){
                            firstProductName=productDetailsPage.getProductName();
                            //firstMerchantName=productDetailsPage.getMerchantName();//Urlden alıncak
                        }
                        else if(i==1){
                            secondProductName=productDetailsPage.getProductName();
                           // secondMerchantName=productDetailsPage.getMerchantName();
                        }

                        productDetailsPage.addToCard();

                        driver.navigate().back();
                        WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofMillis(10000));
                        Assert.assertTrue(driverWait.until(ExpectedConditions.titleIs(title)));
                        scrollIntoElementAndClick(productDetailsPage.merchantTabTriggerLocator);
                    }
                }
                break;
            }
        }
        driver.close();
        driver.switchTo().window(firstWindow);
    }


}

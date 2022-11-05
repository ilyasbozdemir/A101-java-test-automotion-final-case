package pages.HepsiBurada;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PagePath;
import java.time.Duration;
import java.util.List;
public class ProductsPage extends BasePage{
    public By productNameLocator =  getPropertiesToXPath(PagePath.productsPagePath,"productNameLocator");

    ProductDetailsPage productDetailsPage;
    BasketPage basketPage;
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
        basketPage= new BasketPage(driver);
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
                        merchantElement.click();//

                        System.out.println("productDetailsPage");

                        System.out.println(productDetailsPage.getProductName() + " - " + productDetailsPage.getMerchantName());

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

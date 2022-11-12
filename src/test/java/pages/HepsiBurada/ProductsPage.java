package pages.HepsiBurada;

import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.entities.Product;
import utilities.PagePath;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {
    public By productNameLocator = getPropertiesToXPath(PagePath.productsPagePath, "productNameLocator");
    ProductDetailsPage productDetailsPage;
    CardPage basketPage;
    public WebElement selectedProduct;

    public ProductsPage(WebDriver driver) {
        super.driver = driver;
    }

    public List<WebElement> getAllProducts() {
        return findAll(productNameLocator);
    }

    public void selectProduct(int index) {

        selectedProduct = getAllProducts().get(index);
        scrollIntoElement(selectedProduct);
        hover(selectedProduct);
    }

    public boolean productsBeenAddedToTheCart() {

        return true;
    }

    public void productsAddToCart() {

        productDetailsPage = new ProductDetailsPage(driver);
        basketPage = new CardPage(driver);
        String firstWindow = driver.getWindowHandle();
        selectedProduct.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);

                scrollIntoElementAndClick(productDetailsPage.merchantTabTriggerLocator);
                productDetailsPage.merchantCount = Integer
                        .parseInt(find(productDetailsPage.merchantCountLocator).getText());

                String title = getTitle();
                int productCount = 2;


                if (productDetailsPage.merchantCount >= productCount) {
                    for (int i = 0; i < productCount; i++) {

                        pageLoadTimeout(Duration.ofSeconds(40));

                        WebElement merchantElement = productDetailsPage.merchantList().get(i);//satıcıları
                        // listele
                        scrollIntoElementAndClick(productDetailsPage.merchantTabTriggerLocator);
                        //satıcı tabına scroll'u indir ve tıkla

                        implicitlyWait(Duration.ofSeconds(40));

                        WebElement merchantNameElement = productDetailsPage.merchantName(i);

                        Product product = new Product();

                        product.productName = productDetailsPage.getProductName();
                        product.merchantName = merchantNameElement.getText();

                        super.productList.add(product);

                        merchantElement.click();
                        pageLoadTimeout(Duration.ofSeconds(40));
                        productDetailsPage.addToCard();
                        driver.navigate().back();

                        Assert.assertTrue(new WebDriverWait(driver, Duration.ofMillis(10000))
                                .until(ExpectedConditions.titleIs(title)));
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

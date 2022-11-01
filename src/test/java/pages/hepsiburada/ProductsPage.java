package pages.HepsiBurada;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductsPage extends BasePage{
    By productNameLocator =  getPropertiesToXPath(PagePath.productsPagePath,"productNameLocator");
  pages.HepsiBurada.ProductDetailsPage productDetailsPage;
    public WebElement selectedProduct;

    public ProductsPage(WebDriver driver){
        super.driver=driver;
    }
    public List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
    public void selectProduct(int index)  {
        selectedProduct =  getAllProducts().get(index);
    }
    public void chooseTwoDifferentProductsAddToCart() throws InterruptedException {

        productDetailsPage = new ProductDetailsPage(driver);
        // test aşamasında
        String firstWindow = driver.getWindowHandle();
        Thread.sleep(3000);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();

        while(itr.hasNext()) {
            Thread.sleep(1000);
            String window = itr.next();

            driver.switchTo().window(window);
            System.out.println(driver.getTitle());

            if(driver.getTitle().equals("Fiyatı")) {
                //diğer satıcılardan da ürünü al

                driver.close();//sekmeyi kapat
            }
        }
        driver.switchTo().window(firstWindow);

    }


}

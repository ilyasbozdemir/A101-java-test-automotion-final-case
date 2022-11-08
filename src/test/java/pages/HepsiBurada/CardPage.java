package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.entities.Product;
import utilities.PagePath;

import java.util.Locale;


public class CardPage extends BasePage {
    public CardPage(WebDriver driver) {
        super.driver = driver;
        this.getUrl = "";
    }

    public By gotoCartLocator =
            getPropertiesToXPath(PagePath.basketPagePath, "gotoCartLocator");
    public By BasketEmptyLocator = new By.ByClassName("content_Z9h8v");

    public By basketItemCount =
            getPropertiesToXPath(PagePath.basketPagePath, "basketItemCount");

    public By productName = new By.ByClassName("product_name_3Lh3t");
    public By productNameFirstElement = new By.ByClassName("product_name_3Lh3t:nth(0)");
    //
    public By merchantName = new By.ByClassName("merchantLink_2Ii8s");
    //
    public By containerLocator = new By.ByClassName("container_HX1zs");//product count container

    public WebElement productQuantity;

    public boolean IsTheProductOnTheList(Product product) {

        for (Product p : super.productList) {
            if (product == p)
                return true;
        }
        return false;
    }

    public boolean goToCartVerifyCart() {
        driver.get("https://checkout.hepsiburada.com/sepetim");

        int counter = 0;

        for (int i = 0; i < findAll(productName).size(); i++) {

            WebElement currentProductElement = findAll(productNameFirstElement).get(i);
            WebElement currentMerchantElement = findAll(merchantName).get(i);
            Product p = new Product();
            p.merchantName = currentMerchantElement.getText().toLowerCase(Locale.ENGLISH);
            p.productName = currentProductElement.getText().toLowerCase(Locale.ENGLISH);

            if (IsTheProductOnTheList(p))
                counter++;

        }

        return counter == 2 ? true : false;
    }

}

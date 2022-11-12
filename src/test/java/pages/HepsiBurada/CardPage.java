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

    public By productNameLocator = new By.ByClassName("product_name_3Lh3t");
    public By productNameFirstElement = By.cssSelector("div.product_name_3Lh3t > a");

    public By merchantName = new By.ByClassName("merchantLink_2Ii8s");

    public boolean IsTheProductOnTheList(Product product) {

        for (Product p : super.productList) {
            if (product == p)
                return true;
        }
        return false;
    }

    public boolean goToCartVerifyCart() {
        driver.get("https://checkout.hepsiburada.com/sepetim");

        System.out.println("super.productList:");

        for (var product : super.productList) {
            System.out.println(product.productName + " " + product.merchantName);
        }

        int size = findAll(productNameFirstElement).size();

        System.out.println("findAll(productName).size()" + size);


        int counter = 0;

        if (isDisplayed(productNameFirstElement) && size > 0) {
            for (int i = 0; i < findAll(productNameFirstElement).size(); i++) {

                Product product = new Product();

                System.out.println("productNameFirstElement.size " + findAll(productNameFirstElement).size());
                System.out.println("merchantName.size " + findAll(merchantName).size());

                WebElement currentProductElement = findAll(productNameFirstElement).get(i);
                WebElement currentMerchantElement = findAll(merchantName).get(i);

                product.merchantName = currentMerchantElement.getText().toLowerCase(Locale.ENGLISH);
                product.productName = currentProductElement.getText().toLowerCase(Locale.ENGLISH);
                System.out.println(product.productName + " - " + product.merchantName);

                if (IsTheProductOnTheList(product))
                    counter++;
            }
        }

        return counter == 2 ? true : false;
    }


}

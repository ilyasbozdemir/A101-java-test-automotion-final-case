package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.util.*;

public class ProductDetailsPage extends BasePage {

    public By addToCardButtonLocator =
            getPropertiesToXPath(PagePath.productDetailsPagePath, "addToCardButtonLocator");
    public By merchantTabTriggerLocator =
            getPropertiesToXPath(PagePath.productDetailsPagePath, "merchantTabTriggerLocator");
    public By merchantListLocator = new By.ByClassName("merchant-list-item");

    public By productName = By.xpath("//*[@id=\"detail-container\"]/div/header/span");


    public int merchantCount = 0;
    public By merchantCountLocator = By.xpath("//*[@id=\"merchantTabTrigger\"]/a/span/span");

    public ProductDetailsPage(WebDriver driver) {
        super.driver = driver;
    }

    public List<WebElement> merchantList() {
        return super.findAll(merchantListLocator);
    }

    public WebElement merchantName(int i) {

        //String xpath = "//*[@id=\"merchant-list\"]/tbody/tr[" + (3 + i) + "]/td[2]/div/a[2]/span";
        //String xpath = "//*[@id=\"merchant-list\"]/tbody/tr[" + (3 + i) + "]/td[2]/div/a/span";

        //a[2] olma sebebi a[1] de rating puanı olmasıdır

        String xpath = "//*[@id=\"merchant-list\"]/tbody/tr[" + (3 + i) + "]/td[2]/div";

        var elements = getChilds(find(By.xpath(xpath)));

        int size = elements.size();
        if (size == 1)
            xpath += "/a/span";
         else if (size == 2)
            xpath += "/a[2]/span";


        By merchantNameLocator = By.xpath(xpath);
        return super.find(merchantNameLocator);
    }

    public String getProductName() {
        return find(productName).getAttribute("innerText").trim();
    }

    public void addToCard() {
        click(addToCardButtonLocator);
    }
}

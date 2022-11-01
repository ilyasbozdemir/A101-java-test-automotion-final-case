package pages.hepsiburada.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.util.List;

public  class BasePage {
    WebDriver driver;
    public  String getUrl;
    public String expectedTitle="";
    public String getTitle="";
    public void hover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(find(locator)).perform();
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public  By getPropertiesToXPath(PagePath path, String Key){
       return By.xpath(PropertiesFile.getProperties(path,Key));
    }

}

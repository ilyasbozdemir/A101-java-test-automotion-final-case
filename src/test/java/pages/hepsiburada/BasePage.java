package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PagePath;
import utilities.PropertiesFile;

import java.time.Duration;
import java.util.List;

public  class BasePage {
    WebDriver driver ;

    public String getUrl;
    public String expectedTitle;
    public String getTitle;


    public void hover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(find(locator)).perform();
    }
    public void hover(WebElement Element){
        Actions action = new Actions(driver);
        action.moveToElement(Element).perform();
    }
    public void scrollElement(){

    }
    public void scrollIntoElement(By locator) {
        Actions a = new Actions(driver);
        a.moveToElement(find(locator));
        a.perform();
    }
    public void scrollIntoElement(WebElement element) {
        Actions a = new Actions(driver);
        a.moveToElement(element);
        a.perform();
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getText(By locator){
        return find(locator).getText();
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public  By getPropertiesToXPath(PagePath path, String Key){
       return By.xpath( PropertiesFile.getProperties(path,Key));
    }
    public void scrollIntoElementAndClick(By locator){
        scrollIntoElement(locator);
        click(locator);
    }

}

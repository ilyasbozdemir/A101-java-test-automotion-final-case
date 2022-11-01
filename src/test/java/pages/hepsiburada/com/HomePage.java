package pages.hepsiburada.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PagePath;
import utilities.PropertiesFile;

public class HomePage extends BasePage {
    public By acceptCookiesLocator = getPropertiesToXPath(PagePath.homePagePath,"acceptCookiesLocator");
    public By searchInboxLocator=getPropertiesToXPath(PagePath.homePagePath,"searchInboxLocator");
    public By searchButtonLocator=getPropertiesToXPath(PagePath.homePagePath,"searchButtonLocator");
    public By specialTodayLocator=getPropertiesToXPath(PagePath.homePagePath,"specialTodayLocator");

    public By loginButtonLocator=getPropertiesToXPath(PagePath.homePagePath,"loginButtonLocator");
    public By loginOrSignUpLocator=getPropertiesToXPath(PagePath.homePagePath,"loginOrSignUpLocator");
    public By seaarchFirstProductLocator=getPropertiesToXPath(PagePath.homePagePath,"seaarchFirstProductLocator");


    public HomePage(WebDriver driver){

        super.driver=driver;
        this.getUrl=PropertiesFile.getProperties(PagePath.configurationPath,"basePath");

        super.getTitle=driver.getTitle();
        super.expectedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
    }
    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator))
            click(acceptCookiesLocator);
    }


    public void gotoLoginOrSignUp(){
        hover(loginOrSignUpLocator);
        click(loginButtonLocator);
    }

    public void searchProduct(String productName) {
        type(searchInboxLocator,productName);
        click(seaarchFirstProductLocator);
    }
}

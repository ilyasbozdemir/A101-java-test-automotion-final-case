package pages.hepsiburada.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PagePath;

public class LoginOrSignUpPage extends BasePage{

    public LoginOrSignUpPage(WebDriver driver){
        super.driver=driver;
        super.getUrl="https://giris.hepsiburada.com/?ReturnUrl=https%3A%2F%2Foauth.hepsiburada.com%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DSPA%26redirect_uri%3Dhttps%253A%252F%252Fwww.hepsiburada.com%252Fuyelik%252Fcallback%26response_type%3Dcode%26scope%3Dopenid%2520profile%26state%3D5b4ce161855b4389b69019d0793cc57a%26code_challenge%3DllTaWXzbxu1Sji4rHmVyvb-tw0bMMZOaH5Eg5pEC2PE%26code_challenge_method%3DS256%26response_mode%3Dquery%26ActivePage%3DPURE_LOGIN%26oidcReturnUrl%3Dhttps%253A%252F%252Fwww.hepsiburada.com";
        super.getTitle=driver.getTitle();
        super.expectedTitle="Üye Giriş Sayfası & Üye Ol - Hepsiburada";
    }
    //getPropertiesToXPath(PagePath.homePagePath,"acceptCookiesLocator");
    public By loginTabLocator=getPropertiesToXPath(PagePath.loginOrSignUpPagePath,"loginTabLocator");
    public By loginButtonLocator=getPropertiesToXPath(PagePath.loginOrSignUpPagePath,"loginButtonLocator");
    public By emailInputLocator=getPropertiesToXPath(PagePath.loginOrSignUpPagePath,"emailInputLocator");
    public By passwordInputLocator=getPropertiesToXPath(PagePath.loginOrSignUpPagePath,"passwordInputLocator");
    public By emailSelectButtonLocator=getPropertiesToXPath(PagePath.loginOrSignUpPagePath,"emailSelectButtonLocator");


    public void Register(String emailAddress,String password){

    }
    public void Login(String emailAddress,String password){

        type(emailInputLocator,emailAddress);
        click(loginButtonLocator);
        type(passwordInputLocator,password);
        click(emailSelectButtonLocator);
    }

    public boolean isOnLoginOrSignUpPage() {
        return  isDisplayed(loginTabLocator);
    }
}

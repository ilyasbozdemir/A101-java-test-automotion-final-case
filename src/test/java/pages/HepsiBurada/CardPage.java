package pages.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PagePath;


public class CardPage extends BasePage{
    public CardPage(WebDriver driver){
        super.driver=driver;
        this.getUrl="";
    }
    public By gotoCartLocator =
            getPropertiesToXPath(PagePath.basketPagePath,"gotoCartLocator");
    public By BasketEmptyLocator =new By.ByClassName("content_Z9h8v");

    public By  basketItemCount=
            getPropertiesToXPath(PagePath.basketPagePath,"basketItemCount");

    public By productName =new By.ByClassName("product_name_3Lh3t");
    //
    public By merchantName =new By.ByClassName("merchantLink_2Ii8s");
    //
    public By containerLocator =new By.ByClassName("container_HX1zs");//product count container

    public WebElement productQuantity;
    //

    public void goToCartVerifyCart() {
        driver.get("https://checkout.hepsiburada.com/sepetim");


    for(int i=0;i<findAll(productName).size();i++){
        boolean state1=false,state2=false;

        if(i==0){
            System.out.println(firstProductName+ " " +  findAll(productName).get(i).getText());

        }
        else{
            System.out.println(secondProductName+ " " +  findAll(productName).get(i).getText());

        }


        System.out.println(state1+ " " +  state2);
        System.out.println(firstMerchantName+ " " +  secondMerchantName);

        if(state1 && state2){

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("alert('Congratulations, your test was successful.');");
        }
    }
}

}

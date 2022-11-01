package utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();

    static  File projectDirectory = new File(System.getProperty("user.dir"));
    static File subDirectory = new File(projectDirectory, "env");
    static File configuration = new File(subDirectory, "configuration.properties");
    static File homePage = new File(subDirectory, "pages\\homePage.properties");
    static  File basketPage = new File(subDirectory, "pages\\basketPage.properties");
    static File loginOrSignUpPage = new File(subDirectory, "pages\\loginOrSignUpPage.properties");
    static File productsPage = new File(subDirectory, "pages\\products.properties");
    static File productDetailsPage = new File(subDirectory, "pages\\productDetails.properties");


    private static  String getFilePath(PagePath path){

        if(path== PagePath.homePagePath)
            return homePage.getPath();
        else if(path== PagePath.productsPagePath)
            return productsPage.getPath();
        else if(path== PagePath.productDetailsPagePath)
            return productDetailsPage.getPath();
        else if(path== PagePath.loginOrSignUpPagePath)
            return loginOrSignUpPage.getPath();
        else if(path== PagePath.basketPagePath)
            return basketPage.getPath();
        else
            return configuration.getPath();

    }

    static public void setProperties(PagePath path, String key, String value, String comments){
        String filePath= getFilePath(path);
        File file = new File(filePath);
        try {
            OutputStream output = new FileOutputStream(file);
            prop.setProperty(key, value);
            prop.store(output, comments);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    static public String getProperties(PagePath path, String key){
        String data="";
        String filePath= getFilePath(path);
        File file = new File(filePath);
        try {
            InputStream input = new FileInputStream(file);
            prop.load(input);
            data = prop.getProperty(key);

            System.out.println(path.toString()+" "+key +" "+data);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return  data;
    }
}
package tests.Abstract;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.hepsiburada.com.HomePage;

public interface Testable {

    @AfterTest
    public void afterMethod();
    @BeforeTest
    public void beforeMethod();
}

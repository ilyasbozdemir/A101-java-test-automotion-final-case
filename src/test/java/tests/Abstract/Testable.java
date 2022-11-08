package tests.Abstract;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public interface Testable {
    @BeforeTest
    public void beforeMethod();

    @AfterTest
    public void afterMethod();
}

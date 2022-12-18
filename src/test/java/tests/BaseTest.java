package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod (alwaysRun = true)
    public void setup() throws InterruptedException{
        Thread.sleep (3000);
        driver = DriverManager.getInstance().setDriver();
        driver.get("https://www.booking.com/");
        softAssert = new SoftAssert();
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}

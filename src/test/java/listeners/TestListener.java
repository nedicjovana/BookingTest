package listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener{
    private static final Logger logger = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("STARTING TEST METHOD: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("TEST METHOD: " + result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("TEST METHOD: " + result.getMethod().getMethodName() + " FAILED");
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest)testClass).getDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }
}

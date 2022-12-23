package pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class.getName());
//    private long waitTime = Long.parseLong(Utils.dotEnv().get("EXPLICIT_WAIT_TIME"));

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    protected WebElement getElement (By locator){
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (StaleElementReferenceException st) {
            logger.warn("Stale Element Exception occured.");
            st.printStackTrace();
            driver.findElement(locator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    protected void typeIn (By locator, String text){
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnElement (By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        logger.info("Searching: " + locator.toString()); //da me obavesti za sve elemente koje je pokusao da klikne
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (ElementClickInterceptedException ex){
            logger.warn("ElementClickInterceptedException occurred!");
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            hoverAndClick(locator);
        }catch (StaleElementReferenceException se){
            getElement(locator).click();
            logger.warn("Stale Element Exception occurred!");
        }catch (TimeoutException te){
            te.printStackTrace();
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click()", element);
            logger.warn("TimeoutException occurred!");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("FAILED - Unable to click on element " + locator.toString());
        }
    }

    protected WebElement getWebElement (WebElement webElement, By locator){
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (StaleElementReferenceException st) {
            logger.warn("Stale Element Exception occured.");
            st.printStackTrace();
            webElement.findElement(locator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
    protected void clickOnWebElement (WebElement element, By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (ElementClickInterceptedException ex){
            logger.warn("ElementClickInterceptedException occurred!");
            wait.until(ExpectedConditions.elementToBeClickable(element));
            getWebElement(element, locator).click();
        }catch (StaleElementReferenceException se){

            getWebElement(element, locator).click();
            logger.warn("Stale Element Exception occurred!");
        }catch (TimeoutException te){
            te.printStackTrace();
            WebElement element1 =  getWebElement(element, locator);
            js.executeScript("arguments[0].click()", element1);
            logger.warn("TimeoutException occurred!");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("FAILED - Unable to click on element ");
        }
    }



//    protected boolean clickOnWebElement (WebElement webElement, By locator){
//        logger.info("Searching: " + locator.toString());
//        boolean result = false;
//        int repeat = 0;
//        while (repeat < 4) {
//            logger.info("pokusaj" + repeat);
//            try {
//                webElement.findElement(locator).click();
//                result = true;
//                break;
//            } catch (StaleElementReferenceException exc) {
//                exc.printStackTrace();
//            }
//            repeat++;
//        }
//        return result;
//    }

    protected void hoverAndClick(By locator) {
        new Actions(driver)
                .moveToElement(getElement(locator))
                .click()
                .perform();
    }

    protected void scrollToMyElement (By locator){
        WebElement element = getElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }



//     public String getFirstPrice (By locatorPrice){
//         String price;
//         int a = this.clickOnRandomElementFromListRoomAndReturnIndex(locatorRoom);
//         List<WebElement> list = driver.findElements(locatorPrice);
//         price = list.get(a).getText();
//         return price;
//     }
     public String getTextFromElement (By locator){

        return getElement(locator).getText();
     }



}

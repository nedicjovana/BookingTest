package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    protected WebElement getElement (By locator){
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (ElementClickInterceptedException ex){
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            hoverAndClick(locator);
        }catch (StaleElementReferenceException se){
            getElement(locator).click();
        }catch (TimeoutException te){
            te.printStackTrace();
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click()", element);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unable to click on element");
        }
    }

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

     public String clickOnRandomElementFromListRoomAndReturnPrice(By locatorRoom, By locatorPrice){
        Random random = new Random();
         String price;
         List<WebElement> list = driver.findElements(locatorRoom);
         List<WebElement> list1 = new ArrayList<>();
         for (int i=0; i< list.size(); i++){
            if (list.get(i).getText().contains("Doručak uključen u cenu")){
                list1.add(list.get(i));
            }
        }
         int randomIndex = random.nextInt(list1.size());
         list1.get(randomIndex).click();
         price = list1.get(randomIndex).findElement(locatorPrice).getText();
         return price;
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

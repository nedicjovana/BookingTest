package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class ChooseConditionAndHotel extends BasePage{

    private By checkBreakfast = By.xpath("//div[@id='left']//div[@class='ffa9856b86 ad9a06523f']//div[@data-filters-item='mealplan:mealplan=1']");
//    private By chooseHotel = By.cssSelector(".b8b0793b0e");
    private By takePrice = By.xpath("//div[@class='d4924c9e74']//span[@data-testid='price-and-discounted-price']");
    private By hotels = By.xpath("//div[@class='d4924c9e74']//div[@data-testid='property-card']");
//    private By buttonShowAvailability = By.cssSelector("a[class*='fc63351294 a822bdf511']>span[class='e57ffa4eb5']");
    private By buttonImg = By.xpath("//a[contains(@href, 'from=searchresult')]/child::img[@data-testid='image']");

    public String price;


    public ChooseConditionAndHotel(WebDriver driver) {
        super(driver);
    }

    public ChooseConditionAndHotel chooseCondition(){
        scrollToMyElement(checkBreakfast);
        clickOnElement(checkBreakfast);
        return this;
    }

    public List<WebElement> listOfBreakfastOnlyHotel() {
        List<WebElement> list = driver.findElements(hotels);
        List<WebElement> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getText().contains("Breakfast included")) { //contains  mi kaze da mora da sadrzi bas ovakav niz stringova
                    list1.add(list.get(i));
                }
            }
        return list1;
    }

    public int chooseRandomElementFromHotelLIst() {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException exc){
            exc.printStackTrace();
        }
        Random random = new Random();
        List<WebElement> list = listOfBreakfastOnlyHotel();
        int randomIndex = random.nextInt(list.size());
        return randomIndex;
    }

    public  String saveRoomPriceAndClickOnHotel (){
        int index = chooseRandomElementFromHotelLIst();
        String price;
        List<WebElement> list = listOfBreakfastOnlyHotel();
        price= list.get(index).findElement(takePrice).getText();
        clickOnWebElement(list.get(index),buttonImg);
        return price;
    }



}

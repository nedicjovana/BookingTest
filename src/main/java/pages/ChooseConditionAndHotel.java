package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
    List<WebElement> hotelsList;


    public ChooseConditionAndHotel(WebDriver driver) {
        super(driver);
    }

    public ChooseConditionAndHotel chooseCondition(){
        scrollToMyElement(checkBreakfast);
        clickOnElement(checkBreakfast);
        return this;
    }

    public void listOfBreakfastOnlyHotel() {
        List<WebElement> list = driver.findElements(hotels);
        hotelsList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().contains("Breakfast included")) { //contains  mi kaze da mora da sadrzi bas ovakav niz stringova
                hotelsList.add(list.get(i));
            }
        }
    }

    public int chooseRandomElementFromHotelLIst() {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException exc){
            exc.printStackTrace();
        }
        Random random = new Random();
        listOfBreakfastOnlyHotel();
        int randomIndex = random.nextInt(hotelsList.size());
        return randomIndex;
    }

    public  void saveRoomPriceAndClickOnHotel (){
        int index = chooseRandomElementFromHotelLIst();
        String subPrice= hotelsList.get(index).findElement(takePrice).getText();
        String[] elements = subPrice.split(" ");
        List<String> list1 = Arrays.asList(elements);
        price = list1.get(1);
        clickOnWebElement(hotelsList.get(index),buttonImg);

    }




}

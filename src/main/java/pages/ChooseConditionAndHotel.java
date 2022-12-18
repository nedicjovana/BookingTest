package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Getter
public class ChooseConditionAndHotel extends BasePage{

    private By checkBreakfast = By.xpath("//div[@id='left']//div[@class='ffa9856b86 ad9a06523f']//div[@data-filters-item='mealplan:mealplan=1']");
//    private By chooseHotel = By.cssSelector(".b8b0793b0e");
    private By takePrice = By.xpath("//div[@class='d4924c9e74']//span[@data-testid='price-and-discounted-price']");
    private By hotels = By.xpath("//div[@class='d4924c9e74']//div[@data-testid='property-card']");
    private By buttonShowAvailability = By.cssSelector("a[class*='fc63351294 a822bdf511']>span[class='e57ffa4eb5']");

    public String price;


    public ChooseConditionAndHotel(WebDriver driver) {
        super(driver);
    }

    public ChooseConditionAndHotel chooseCondition(){
        scrollToMyElement(checkBreakfast);
        clickOnElement(checkBreakfast);
        return this;
    }

    public void chooseHotel(){

        price = clickOnRandomElementFromListRoomAndReturnPrice(hotels, buttonShowAvailability, takePrice);
    }
}

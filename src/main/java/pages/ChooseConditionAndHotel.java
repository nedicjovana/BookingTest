package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Getter
public class ChooseConditionAndHotel extends BasePage{

    private By checkBreakfast = By.xpath("div>label[for=\"__bui-c17268-54\"]>span[class=\"bbdb949247\"]");
//    private By chooseHotel = By.cssSelector(".b8b0793b0e");
    private By takePrice = By.cssSelector(".fcab3ed991.fbd1d3018c");
    private By hotels = By.cssSelector(".a826ba81c4.fe821aea6c.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942");

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

        price = clickOnRandomElementFromListRoomAndReturnPrice(hotels, takePrice);
    }
}

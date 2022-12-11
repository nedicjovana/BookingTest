package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DefinitelyBook extends BasePage {
    private By roomDropDown = By.id("hprt_nos_select_406549108_284983292_2_33_0");
    public By buttonDefinitelyBook = By.cssSelector(".bui-button__text.js-reservation-button__text");


    public DefinitelyBook(WebDriver driver) {
        super(driver);
    }

    private void selectRoom (){
        scrollToMyElement(roomDropDown);
        Select select = new Select (getElement(roomDropDown));
        select.selectByValue("1");
    }

    public DefinitelyBook goToReservationForm(){
        selectRoom();
        clickOnElement(buttonDefinitelyBook);
        return this;
    }


}

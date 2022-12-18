package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DefinitelyBook extends BasePage {
    private By roomDropDown = By.xpath("//table[@id='hprt-table']/child::tbody/child::tr/td[5]/child::div[@class='hprt-block']/child::select[1]");
    public By buttonDefinitelyBook = By.xpath("//div[@class='hprt-reservation-cta']/button[1]");


    public DefinitelyBook(WebDriver driver) {
        super(driver);
    }

    private void selectRoom (){
//        scrollToMyElement(roomDropDown);
        Select select = new Select (getElement(roomDropDown));
        select.selectByValue("1");
    }

    public DefinitelyBook goToReservationForm(){
        selectRoom();
        clickOnElement(buttonDefinitelyBook);
        return this;
    }




}

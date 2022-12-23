package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DefinitelyBook extends BasePage {
    private By roomDropDown = By.xpath("//select[@class='hprt-nos-select js-hprt-nos-select']/parent::div");
    public By buttonDefinitelyBook = By.xpath("//div[@class='hprt-reservation-cta']/child::button");


    public DefinitelyBook(WebDriver driver) {
        super(driver);
    }

    private WebElement chooseRoom(By locator){
        WebElement dropDown;
        List<WebElement> list = driver.findElements(locator);
        dropDown = list.get(0);
        return dropDown;
    }

    private void selectRoom(){
//        scrollToMyElement(roomDropDown);
        Select select = new Select (chooseRoom(roomDropDown));
        select.selectByValue("1");
    }


    public DefinitelyBook goToReservationForm(){
        selectRoom();
        clickOnElement(buttonDefinitelyBook);
        return this;
    }




}

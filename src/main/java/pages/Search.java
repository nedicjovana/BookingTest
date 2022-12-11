package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends BasePage{

    private By searchField= By.cssSelector(".xp__input-group.xp__search");
//    private By clearSearchFieldButton = By.xpath(".bk-icon.-streamline-close.sb-destination__clear-icon>path");
    private By inputDestination = By.xpath("li[data-i=\"1\"]");
    private By dateButton = By.cssSelector(".ed2ff9f661");
    private By dateStart = By.xpath("tr>td[class=\"bui-calendar__date bui-calendar__date--selected\"]>span[aria-label=\"31 decembar 2022\"]");
    private By dateEnd = By.xpath("tr>td[class=\"bui-calendar__date bui-calendar__date--selected\"]>span[aria-label=\"7 januar 2023\"]");
    private By buttonSearch = By.className("js-sb-submit-text");


    public Search(WebDriver driver) {

        super(driver);
    }

    public Search searchHotel(){
        clickOnElement(searchField);
        hoverAndClick(inputDestination);
        hoverAndClick(dateButton);
        hoverAndClick(dateStart);
        hoverAndClick(dateEnd);
        clickOnElement(buttonSearch);
        return this;
    }
}

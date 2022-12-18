package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends BasePage{

    private By searchField= By.xpath("//span[@class='bui-u-sr-only']/following::input[@id='ss']");
//    private By clearSearchFieldButton = By.xpath(".bk-icon.-streamline-close.sb-destination__clear-icon>path");
    private By inputDestination = By.xpath("//li[@data-label='Kopaonik']");
//    private By dateButton = By.xpath("//div[@class='xp__dates-inner']");
    private By dateStart = By.xpath("//td[@data-date='2022-12-31']");
    private By dateEnd = By.xpath("//td[@data-date='2023-01-07']");
    private By buttonSearch = By.xpath("//button[@class='sb-searchbox__button ']");


    public Search(WebDriver driver) {

        super(driver);
    }

    public Search searchHotel(){
          clickOnElement(searchField);
          hoverAndClick(inputDestination);
//          hoverAndClick(dateButton);
          hoverAndClick(dateStart);
          hoverAndClick(dateEnd);
          clickOnElement(buttonSearch);
          return this;
    }
}

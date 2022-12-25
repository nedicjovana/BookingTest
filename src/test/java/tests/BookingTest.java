package tests;

import core.DriverManager;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChooseConditionAndHotel;
import pages.DefinitelyBook;
import pages.Reservation;
import pages.Search;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.ArrayList;

@Listeners(TestListener.class)
public class BookingTest extends BaseTest{
    Search search;
    Reservation reservation;
    DefinitelyBook definitelyBook;
    ChooseConditionAndHotel chooseConditionAndHotel;
    @BeforeMethod (alwaysRun = true)
    public void localSetUp(){
        search = new Search(driver);
        reservation = new Reservation(driver);
        definitelyBook = new DefinitelyBook(driver);
        chooseConditionAndHotel = new ChooseConditionAndHotel(driver);

    }

    @Test
    public void bookingHotelTest(){
         search.searchHotel();
         chooseConditionAndHotel.chooseCondition()
                                .saveRoomPriceAndClickOnHotel();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        definitelyBook.goToReservationForm();
        reservation.bookingField()
                    .goToFinalData();
        softAssert.assertTrue(reservation.matchesExpectedText(chooseConditionAndHotel.getPrice()));

    }



}

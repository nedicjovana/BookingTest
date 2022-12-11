package tests;

import core.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import pages.ChooseConditionAndHotel;
import pages.DefinitelyBook;
import pages.Reservation;
import pages.Search;
import org.testng.annotations.BeforeMethod;

public class BookingTest extends BaseTest{
    Search search;
    Reservation reservation;
    DefinitelyBook definitelyBook;
    ChooseConditionAndHotel chooseConditionAndHotel;
    @BeforeMethod
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
                                .chooseHotel();
         definitelyBook.goToReservationForm();
         reservation.bookingField()
                    .goToFinalData();
         Assert.assertTrue(reservation.matchesExpectedText(chooseConditionAndHotel.getPrice()));
    }



}

package pages;

import lombok.Getter;
import model.BookingField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
@Getter

public class Reservation extends BasePage {

    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email");
    private By emailConfirmField = By.id("email_confirm");
    public String email;
    public By buttonFinalData = By.cssSelector(".bui-button__text.js-button__text");
    String finalPrice;


    private By totalPrice = By.xpath("//div[@class='bp-price-details__charge-value e2e-price-details__total-charge--user']");
    private static final Logger logger = LogManager.getLogger(Reservation.class.getName());
    public Reservation(WebDriver driver) {
        super(driver);
    }


    public Reservation bookingField() {
        BookingField bookingField = new BookingField();
        email = bookingField.getEmail();
        typeIn(firstNameField, bookingField.getFirstName());
        typeIn(lastNameField, bookingField.getLastName());
        typeIn(emailField, email);
        typeIn(emailConfirmField, email);
        return this;
    }

    public Reservation goToFinalData() {
        scrollToMyElement(buttonFinalData);
        clickOnElement(buttonFinalData);
        return this;
    }

    public String convertPriceStringToList(By totalPrice) {
        finalPrice = getTextFromElement(totalPrice);
        String[] elements = finalPrice.split(" ");
        List<String> list = Arrays.asList(elements);
        return list.get(1);
    }

    public boolean matchesExpectedText(String expectedResult) {
        String actualResult = convertPriceStringToList(totalPrice);
        if (expectedResult.equals(actualResult)) {
           logger.info("PASSED - Text found in element " + actualResult + " MATCHES expected text: " + expectedResult);
            return true;
        } else {
            logger.error("FAILED -Text found in element " + actualResult + " DOESN'T MATCH expected text: " + expectedResult);
        }
        return false;
    }
}








package model;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import java.util.Locale;

@Getter
@Setter
public class BookingField {

    private String firstName;
    private String lastName;
    private String email;

    Faker faker = new Faker(new Locale("en-US"));

    public BookingField() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
    }


}

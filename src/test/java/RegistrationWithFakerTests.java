import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsComponent;

import java.util.Locale;

public class RegistrationWithFakerTests {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsComponent resultsComponent = new RegistrationResultsComponent();

    static Faker faker = new Faker(new Locale("en"));

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 60000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillInFieldsTest() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String phoneNumber = faker.number().digits(10);
        String streetAddress = faker.address().streetAddress();
        String gender = faker.options().option("Male", "Female", "Other");
        String subject = faker.options().option("Maths", "Physics", "Chemistry");
        String hobby = faker.options().option("Sports", "Reading", "Music");

        String month = faker.options().option(
                "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"
        );

        int day = faker.number().numberBetween(1, 28);
        int year = faker.number().numberBetween(1990, 2010);

        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(String.valueOf(day), month, String.valueOf(year))
                .setSubject(subject)
                .setHobbies(hobby)
                .setCurrentAddress(streetAddress)
                .uploadPicture("ForDemoQaTests.jpeg")
                .selectState(state)
                .selectCity(city)
                .submitForm();

        resultsComponent
                .verifyModalOpened()
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(gender)
                .checkResult(phoneNumber)
                .checkResult(streetAddress)
                .checkResult(state + " " + city);
    }
}

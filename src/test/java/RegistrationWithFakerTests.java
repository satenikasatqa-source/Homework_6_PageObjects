import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Month;
import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithFakerTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 60000;
    }

    @Test
    void fillInFieldsTest() {

        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String phoneNumber = faker.number().digits(10);
        String streetAddress = faker.address().streetAddress();
        String gender = faker.options().option("Male", "Female", "Other");
        String subject = faker.options().option("Maths", "Physics", "Chemistry");
        String hobby = faker.options().option("Sports", "Reading", "Music");
        String state = "NCR";
        String city = "Delhi";
        int year = faker.number().numberBetween(1990, 2010);
        Month month = faker.options().option(Month.values());
        int day = faker.number().numberBetween(1, 28);

        open("/automation-practice-form");

        $(".practice-form-wrapper")
                .shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month.getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH));
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        $(".react-datepicker__day--0" + String.format("%02d", day)
                + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("ForDemoQaTests.jpeg");
        $("#currentAddress").setValue(streetAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(phoneNumber),
                text(streetAddress)
        );
    }
}








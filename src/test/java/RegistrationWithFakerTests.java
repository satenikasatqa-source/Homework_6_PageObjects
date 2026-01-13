import com.codeborne.selenide.Configuration;
import data.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsComponent;

public class RegistrationWithFakerTests {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsComponent resultsComponent = new RegistrationResultsComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 60000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillInFieldsTest() {
        TestData data = new TestData();

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserEmail(data.userEmail)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .setDateOfBirth(String.valueOf(data.day), data.month, String.valueOf(data.year))
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .setCurrentAddress(data.streetAddress)
                .uploadPicture("ForDemoQaTests.jpeg")
                .selectState(data.state)
                .selectCity(data.city)
                .submitForm();

        resultsComponent
                .verifyModalOpened()
                .checkResult(data.firstName + " " + data.lastName)
                .checkResult(data.userEmail)
                .checkResult(data.gender)
                .checkResult(data.phoneNumber)
                .checkResult(data.streetAddress)
                .checkResult(data.state + " " + data.city);
    }
}

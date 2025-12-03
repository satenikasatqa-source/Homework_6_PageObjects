import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationResultsPage;

public class RegistrationWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsPage resultsPage = new RegistrationResultsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";   // more common, but 1980x1080 also works
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 60000;
    }

    @Test
    void fillInFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setUserEmail("tester@gmail.com")
                .setUserNumber("9876543210")
                .setGender("Female")
                .setDateOfBirth("6", "January", "1980")
                .setSubject("Maths")
                .setHobbies("Reading")
                .setCurrentAddress("Yerevan some street")
                .uploadPicture("ForDemoQaTests.jpeg")
                .selectState("NCR")
                .selectCity("Noida")
                .submitForm();

        resultsPage
                .checkResult("Ivanna Ivanova")
                .checkResult("tester@gmail.com")
                .checkResult("Female")
                .checkResult("9876543210")
                .checkResult("06 January,1980")
                .checkResult("Maths")
                .checkResult("Reading")
                .checkResult("Yerevan some street")
                .checkResult("ForDemoQaTests.jpeg")
                .checkResult("NCR Noida");
    }

    @Test
    void fillInMinFieldsTests() {
        registrationPage.openPage()
                .setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("9876543210")
                .submitForm();
        resultsPage
                .checkResult("Ivanna Ivanova")
                .checkResult("Female")
                .checkResult("9876543210");

    }

    @Test
    void fillInInvalidEmailTests() {
        registrationPage.openPage()
                .setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("9876543210")
                .setUserEmail("tester@gmail")
                .submitForm()
                .checkInvalidEmailError();
    }

}













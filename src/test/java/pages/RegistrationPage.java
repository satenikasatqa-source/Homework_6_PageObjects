package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.attributeMatching;
public class RegistrationPage {

    // элементы страницы
    private SelenideElement
            firstNameInput      = $("#firstName"),
            lastNameInput       = $("#lastName"),
            userEmailInput      = $("#userEmail"),
            userNumberInput     = $("#userNumber"),
            genderWrapper       = $("#genterWrapper"),
            calendarInput       = $("#dateOfBirthInput"),
            subjectInput        = $("#subjectsInput"),
            hobbiesWrapper      = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress");


    private final CalendarComponent calendarComponent = new CalendarComponent();

    // открытие формы
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;
    }


    public RegistrationPage selectState(String stateName) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(stateName)).click();
        return this;
    }

    public RegistrationPage selectCity(String cityName) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(cityName)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        $("#submit").click();
        return this;
    }
    public RegistrationPage checkInvalidEmailError() {
        userEmailInput.shouldHave(attributeMatching("validationMessage", ".+"));
        return this;
    }

}


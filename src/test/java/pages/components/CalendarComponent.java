package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();

    }

}

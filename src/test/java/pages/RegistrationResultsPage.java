package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsPage {

    public RegistrationResultsPage checkResult(String value) {
        $(".table-responsive table").shouldHave(text(value));
        return this;
    }
}


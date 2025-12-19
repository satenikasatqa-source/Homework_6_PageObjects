package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsComponent {

    private SelenideElement
            modalTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public RegistrationResultsComponent verifyModalOpened() {
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationResultsComponent checkResult(String value) {
        resultsTable.shouldHave(text(value));
        return this;
    }
}


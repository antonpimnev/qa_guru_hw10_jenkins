package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $("[class=modal-content]").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResults(String key, String value) {
        $x("//div[@class='table-responsive']").$(byText(key)).parent().shouldHave(text(value));

    }


}
package tests.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private SelenideElement resultTab = $(".table-responsive");

    public void checkResult(String key, String value) {
        resultTab
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}

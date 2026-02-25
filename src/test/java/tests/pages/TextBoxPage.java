package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class TextBoxPage {
    private SelenideElement fullNameInput = $("#userName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitBtn = $("#submit");
    private SelenideElement outputResults = $("#output");

    public TextBoxPage openPage() {
        open("");
        $$(".card-body").findBy(text("Elements")).click();
        $$(".router-link").findBy(text("Text Box")).click();
        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public TextBoxPage checkValue(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));
        return this;
    }

    public void elementShouldNotFind(String... value) {
        for (String s : value) {
            outputResults.shouldNot(text(s));
        }
    }
}

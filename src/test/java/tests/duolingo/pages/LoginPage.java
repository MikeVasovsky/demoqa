package tests.duolingo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement emailInput = $("#web-ui1");
    private SelenideElement passwordInput = $("#web-ui2");
    private SelenideElement submitBtn = $("[data-test='register-button']");
    private SelenideElement errorLoginMessage = $("[data-test='invalid-form-field']");

    public void loginWithIncorrectLogopass(String email, String password){
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitBtn.click();
    }

    public SelenideElement getErrorLoginMessage() {
        return errorLoginMessage;
    }
}

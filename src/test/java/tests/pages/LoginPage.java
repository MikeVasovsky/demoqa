package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement usernameInput = $("#userName");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginBtn = $("#login");
    private SelenideElement errorMessage = $("#name");

    public LoginPage openPage() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Book Store Application"))
                .scrollTo().click();
        $$(".router-link").findBy(text("Login")).click();
        return this;
    }

    public LoginPage setUsernameInput(String value) {
        usernameInput.setValue(value);
        return this;
    }

    public LoginPage setPasswordInput(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public LoginPage clickLogin() {
        loginBtn.click();
        return this;
    }

    public void checkErrorMessage() {
        errorMessage.shouldHave(text("Invalid username or password!"));
    }
}

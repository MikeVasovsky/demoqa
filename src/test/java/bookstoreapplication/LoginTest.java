package bookstoreapplication;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.TestData.*;


public class LoginTest extends tests.TestBase {

    @Test
    void errorIfUserNotRegistered() {
        open(baseUrl + "/login");
        $("#userName").sendKeys(login);
        $("#password").sendKeys(password);
        $("#login").click();

        assertEquals("Invalid username or password!",
                $("#name").getText());
    }

    @Test
    void errorIfUserDontVerifyReCaptchaToRegister() {
        String expectedMessage = "Please verify reCaptcha to register!";
        open(baseUrl + "/login");
        $("#newUser").click();
        $("#firstname").setValue(firstName);
        $("#lastname").setValue(lastName);
        $("#userName").setValue(username);
        $("#password").setValue(password);
        $("#register").click();

        assertEquals(expectedMessage, $(".mb-1").getText());
    }
}

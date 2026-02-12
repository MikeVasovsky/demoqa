package bookstoreapplication;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com/login";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void errorIfUserNotRegistered() {
        open(baseUrl);
        $("#userName").sendKeys("login");
        $("#password").sendKeys("wtf");
        $("#login").click();

        assertEquals("Invalid username or password!",
                $("#name").getText());
    }

    @Test
    void errorIfUserDontVerifyReCaptchaToRegister() {
        String expectedMessage = "Please verify reCaptcha to register!";
        open(baseUrl);
        $("#newUser").click();
        $("#firstname").setValue("name");
        $("#lastname").setValue("lastName");
        $("#userName").setValue("username");
        $("#password").setValue("wtf");
        $("#register").click();

        assertEquals(expectedMessage, $(".mb-1").getText());
    }
}

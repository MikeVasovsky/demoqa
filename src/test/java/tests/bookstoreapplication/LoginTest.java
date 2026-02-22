package tests.bookstoreapplication;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.testdata.TestData.*;


public class LoginTest extends TestBase {

    @Test
    void errorIfUserNotRegisteredTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Book Store Application")).click();
        $$(".router-link").findBy(text("Login")).click();
        $("#userName").sendKeys(badLogin);
        $("#password").sendKeys(badPassword);
        $("#login").click();

        assertEquals("Invalid username or password!",
                $("#name").getText());
    }

    @Test
    void errorIfUserDontVerifyReCaptchaToRegisterTest() {
        String expectedMessage = "Please verify reCaptcha to register!";
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Book Store Application")).click();
        $$(".router-link").findBy(text("Login")).click();
        $("#newUser").click();
        $("#firstname").setValue(firstName);
        $("#lastname").setValue(lastName);
        $("#userName").setValue(username);
        $("#password").setValue(password);
        $("#register").click();

        assertEquals(expectedMessage, $(".mb-1").getText());
    }
}

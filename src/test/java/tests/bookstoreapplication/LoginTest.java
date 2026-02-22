package tests.bookstoreapplication;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;

import static tests.testdata.TestData.*;


public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    void errorIfUserNotRegisteredTest() {
        loginPage
                .openPage()
                .setUsernameInput(badLogin)
                .setPasswordInput(badPassword)
                .clickLogin()
                .checkErrorMessage();
    }
}

package tests.bookstoreapplication;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import tests.testdata.LoginFactory;
import tests.testdata.LoginTestData;


public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();


    @Test
    void errorIfUserNotRegisteredTest() {
        LoginTestData l = LoginFactory.createLoginData();
        loginPage
                .openPage()
                .removeBanner()
                .setUsernameInput(l.getBadLogin())
                .setPasswordInput(l.getBadPassword())
                .clickLogin()
                .checkErrorMessage();
    }
}

package tests.bookstoreapplication;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import tests.testdata.TestData;


public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    public TestData t = new TestData();

    @Test
    void errorIfUserNotRegisteredTest() {
        loginPage
                .openPage()
                .removeBanner()
                .setUsernameInput(t.username)
                .setPasswordInput(t.password)
                .clickLogin()
                .checkErrorMessage();
    }
}

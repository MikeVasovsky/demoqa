package tests.demoqa.bookstoreapplication;

import org.junit.jupiter.api.Test;
import tests.demoqa.TestBase;
import tests.demoqa.pages.LoginPage;
import tests.demoqa.testdata.TestData;


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

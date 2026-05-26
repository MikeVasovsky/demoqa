package tests.booksclub.tests.ui;

import io.qameta.allure.Step;
import tests.booksclub.pages.LoginPage;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Step
    public void openMainPageAfterLoginTest() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());



    }


}

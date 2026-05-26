package tests.booksclub.tests.ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.booksclub.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Проверка отображения логитна на странице профиля")
    public void loginTest() {
        registerUser();
        loginPage.openLoginPage()
                .correctLogin(
                        data.getUsername(),
                        data.getPassword())
                .goToProfilePage()
                .checkCorrectLoginInProfilePage(data);
    }
}

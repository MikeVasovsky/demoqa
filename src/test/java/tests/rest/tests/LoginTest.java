package tests.rest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.login.request.LoginBodyWithoutPassword;
import tests.rest.models.login.request.LoginBodyWithoutUsername;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.LoginBodyWithoutUsernameResponseModel;
import tests.rest.models.login.response.LoginByBadLogopassResponseModel;
import tests.rest.models.login.response.LoginWithourPasswordResponseModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.*;

public class LoginTest extends BaseTest {

    TestData t = new TestData();

    @Test
    @DisplayName("Проверка успешнеой авторизации пользователя")
    void succesfulLoginTest() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        SuccessfullLoginResponseModel response = api.auth.login(data);

        step("Проверки", () -> {
            assertThat(response.getAccess()).contains(LOGIN_TOKEN_PREFIX);
            assertThat(response.getRefresh()).contains(LOGIN_TOKEN_PREFIX);
        });
    }

    @Test
    @DisplayName("Проверка ответа 401 при авторизации незарегистрированного пользователя")
    void unauthorizedLoginTest() {
        LoginFullBodyModel data = new LoginFullBodyModel(t.getRandomUsername(), t.randomPassword);
        LoginByBadLogopassResponseModel response = api.auth.badLogopasslogin(data);

        step("Проверка ответа", () -> assertThat(response.getDetail()).isEqualTo("Invalid username or password."));
    }

    @Test
    @DisplayName("Проверка ответа 400 при авторизации без пароля")
    void passwordAbsenceTest() {
        LoginBodyWithoutPassword data = new LoginBodyWithoutPassword(LOGIN_USERNAME);
        LoginWithourPasswordResponseModel response = api.auth.loginWithoutPassword(data);

        String[] actual = response.getPassword();
        step("Проверки", () ->
                assertThat(actual[0])
                        .isEqualTo("This field is required."));
    }

    @Test
    @DisplayName("Проверка ответа 400 при авторизации без логина")
    void usernameAbsenseTest() {
        LoginBodyWithoutUsername data = new LoginBodyWithoutUsername(LOGIN_USERNAME);
        LoginBodyWithoutUsernameResponseModel response = api.auth.loginWithoutUsername(data);

        step("Проверка ответа", () -> {
            String[] actual = response.getUsername();
            assertThat(actual[0])
                    .isEqualTo("This field is required.");
        });
    }
}
package tests.rest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.login.request.LoginBodyWithoutPassword;
import tests.rest.models.login.request.LoginBodyWithoutUsername;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.*;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.*;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Проверка успешнеой атворизации пользователя")
    void succesfulLogin() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        SuccessfullLoginResponseModel response = api.auth.login(data);

        assertThat(response.getAccess()).contains(LOGIN_TOKEN_PREFIX);
        assertThat(response.getRefresh()).contains(LOGIN_TOKEN_PREFIX);
    }

    @Test
    @DisplayName("Проверка ответа 401 при авторизации незарегистрированного пользователя")
    void unauthorizedLoginTest() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        LoginByBadLogopassResponseModel response = api.auth.badLogopasslogin(data);

        assertThat(response.getDetail()).isEqualTo("Invalid username or password.");
    }

    @Test
    @DisplayName("Проверка ответа 400 при авторизации без пароля")
    void passwordAbsenceTest() {
        LoginBodyWithoutPassword data = new LoginBodyWithoutPassword(LOGIN_USERNAME);
        LoginWithourPasswordResponseModel response = api.auth.loginWithoutPassword(data);

        String[] actual = response.getPassword();
        assertThat(actual[0])
                .isEqualTo("This field is required.");
    }

    @Test
    @DisplayName("Проверка ответа 400 при авторизации без логина")
    void usernameAbsenseTest() {
        LoginBodyWithoutUsername data = new LoginBodyWithoutUsername(LOGIN_USERNAME);
        LoginBodyWithoutUsernameResponseModel response = api.auth.loginWithoutUsername(data);

        String[] actual = response.getUsername();
        assertThat(actual[0])
                .isEqualTo("This field is required.");
    }

}

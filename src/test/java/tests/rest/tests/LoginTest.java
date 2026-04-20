package tests.rest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.login.*;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.*;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Проверка успешнеой атворизации пользователя")
    void succesfulLogin() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        SuccessfulLoginResponseModel response = api.auth.login(data);

        assertThat(response.getAccess()).contains(LOGIN_TOKEN_PREFIX);
        assertThat(response.getRefresh()).contains(LOGIN_TOKEN_PREFIX);
    }

    @Test
    @DisplayName("Проверка ответа 401 при авторизации незарегистрированного пользователя")
    void unauthorizedLoginTest() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, BAD_LOGIN_PASSWORD);
        LoginByBadLogopassResponseModel response = api.auth.badLogopasslogin(data);

        assertThat(response.getDetail()).isEqualTo("Invalid username or password.");
    }

    @Test
    void passwordAbsenceTest() {
        LoginBodyWithoutPassword data = new LoginBodyWithoutPassword(LOGIN_USERNAME);
        LoginWithourPasswordResponseModel response = api.auth.loginWithoutPassword(data);

        String[] actual = response.getPassword();
        assertThat(stream(actual).filter(
                x -> x.equals("This field is required.")
        ));
    }

}

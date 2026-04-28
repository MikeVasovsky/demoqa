package tests.rest.tests;

import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.logout.response.EmptyRefreshResponseBody;
import tests.rest.models.logout.response.LogoutIfTokenInBlacklist;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.LOGIN_PASSWORD;
import static tests.rest.data.TestData.LOGIN_USERNAME;

public class LogoutTest extends BaseTest {

    //Тут вопрос в том, какие проверки добавить
    //Если бы был досьтуп к бд, то можно было бы проверить статус пользователя до логина и после
    //Тк такой возможности щас нети я добавлю проверку, которая по сути является негативным тестом
    @Test
    void correctLogoutAndRepeateLogoutTest() {
        SuccessfullLoginResponseModel response = step(
                "Логин зарегистрированного пользователя", () -> {
                    LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
                    return api.auth.login(data);
                });


        LogoutBodyModel logoutData = new LogoutBodyModel(response.getRefresh());

        step("Разлогин пользователя", () -> {
            api.log.logout(logoutData);
        });

        LogoutIfTokenInBlacklist resultResponse = step(
                "Получение ответа повторного разлогина", () ->
                        api.log.repeatLogout(logoutData));
        assertThat(resultResponse.getCode()).isEqualTo("token_not_valid");
        assertThat(resultResponse.getDetail()).isEqualTo("Token is blacklisted");
    }

    @Test
    void emptyLogoutTest() {
        step("Попытка разлогина без refresh token", () -> {
            LogoutBodyModel logoutData = new LogoutBodyModel("");
            EmptyRefreshResponseBody response = api.log.emptyRefreshLogout(logoutData);

            assertThat(response.getRefresh()[0]).isEqualTo("This field may not be blank.");
        });
    }
}

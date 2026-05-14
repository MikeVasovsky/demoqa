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

    @Test
    void correctLogoutAndRepeateLogoutTest() {

        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        SuccessfullLoginResponseModel response = api.auth.login(data);

        LogoutBodyModel logoutData = new LogoutBodyModel(response.getRefresh());

        api.log.logout(logoutData);

        LogoutIfTokenInBlacklist resultResponse = api.log.repeatLogout(logoutData);
        step("Проверка ответа", () -> {
                    assertThat(resultResponse.getCode()).isEqualTo("token_not_valid");
                    assertThat(resultResponse.getDetail()).isEqualTo("Token is blacklisted");
                }
        );
    }

    @Test
    void emptyLogoutTest() {
        LogoutBodyModel logoutData = new LogoutBodyModel("");
        EmptyRefreshResponseBody response = api.log.emptyRefreshLogout(logoutData);
        step("Проверка ответа", () ->
                assertThat(response.getRefresh()[0]).isEqualTo("This field may not be blank."));
    }
}

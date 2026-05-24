package tests.booksclub.tests.api.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.booksclub.tests.api.BaseTest;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.logout.request.LogoutBodyModel;
import tests.booksclub.rest.models.logout.response.EmptyRefreshResponseBody;
import tests.booksclub.rest.models.logout.response.LogoutIfTokenInBlacklist;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.booksclub.rest.data.TestData.LOGIN_PASSWORD;
import static tests.booksclub.rest.data.TestData.LOGIN_USERNAME;

public class LogoutTest extends BaseTest {
    LoginFullBodyModel data;
    SuccessfullLoginResponseModel response;

    @BeforeEach
    void loginUser(){
        data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        response = api.auth.login(data);
    }

    @Test
    void correctLogoutAndRepeateLogoutTest() {
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

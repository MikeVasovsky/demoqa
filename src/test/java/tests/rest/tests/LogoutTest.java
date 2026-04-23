package tests.rest.tests;

import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.logout.response.LogoutIfTokenInBlacklist;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.LOGIN_PASSWORD;
import static tests.rest.data.TestData.LOGIN_USERNAME;

public class LogoutTest extends BaseTest {

    //Тут вопрос в том, какие проверки добавить
    //Если бы был досьур к бд, то можно было бы проверить статус пользователя до логина и после
    //Тк такой возможности щас нети я добавлю проверку, которая по сути является негативным тестом
    @Test
    void correctLogoutAndRepeateLogourTest() {
        LoginFullBodyModel data = new LoginFullBodyModel(LOGIN_USERNAME, LOGIN_PASSWORD);
        SuccessfullLoginResponseModel response = api.auth.login(data);

        LogoutBodyModel logoutData = new LogoutBodyModel(response.getRefresh());
        api.log.logout(logoutData);

        LogoutIfTokenInBlacklist resultResponse = api.log.repeatLogout(logoutData);
        assertThat(resultResponse.getCode()).isEqualTo("token_not_valid");
        assertThat(resultResponse.getDetail()).isEqualTo("Token is blacklisted");
    }
}

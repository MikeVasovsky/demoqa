package tests.rest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.RegistrationWithoutPasswordAndRepeateUsername;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class RegistrationTest extends BaseTest {
    TestData testData = new TestData();

    @Test
    @DisplayName("Проверка корректной регистрации пользователя и поля username")
    void succesfullRegistrationTest() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);
        step("Проверки ", () -> assertThat(response.getUsername()).isEqualTo(data.getUsername()));
    }

    @Test
    @DisplayName("Проверка корректной регистрации пользователя и поля id")
    void testIdAfterRegistrationTest() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);

        int firstId = response.getId();


        RegistrationFullModel second_data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel second_response = api.reg.registration(second_data);
        step("Проверка id", () -> assertThat(second_response.getId()).isEqualTo(firstId + 1));
    }

    @Test
    @DisplayName("Проверка ошибки 400 при повторном использовании поля username и пустого поля password")
    void repeateUsernameAndEmptyPasswordTest() {
        RegistrationFullModel data = new RegistrationFullModel(testData.randomUsername, testData.randomPassword);
        api.reg.registration(data);

        RegistrationFullModel secondData = new RegistrationFullModel(testData.randomUsername, "");
        RegistrationWithoutPasswordAndRepeateUsername resultResponse = api.reg
                .registrationWithoutPassAndRepeateUsername(secondData);

        step("Проверки ответа", () -> {
            assertThat(resultResponse.getUsername()[0]).isEqualTo("A user with that username already exists.");
            assertThat(resultResponse.getPassword()[0]).isEqualTo("This field may not be blank.");
        });
    }

    @Test
    @DisplayName("Проверка регистрации по с пустыми полями username и password")
    void epmtyBodyRegistrationTest() {
        LogoutBodyModel data = new LogoutBodyModel("");
        RegistrationWithoutPasswordAndRepeateUsername response = api.reg.emptyBodyRegistration(data);
        step("Проверки ответа", () -> {
            assertThat(response.getUsername()[0]).isEqualTo("This field is required.");
            assertThat(response.getUsername()[0]).isEqualTo("This field is required.");
        });
    }
}

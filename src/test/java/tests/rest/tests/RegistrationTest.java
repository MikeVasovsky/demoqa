package tests.rest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.RegistrationWithoutPasswordAndRepeateUsername;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class RegistrationTest extends BaseTest {
    TestData testData = new TestData();

    @Test
    @DisplayName("Проверка корректнгой регистрации пользователя и поля username")
    void succesfullRegistration() {

        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);

        assertThat(response.getUsername()).isEqualTo(data.getUsername());
    }

    @Test
    @DisplayName("Проверка корректнгой регистрации пользователя и поля id")
    void testIdAfterRegistration() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);

        int firstId = response.getId();

        RegistrationFullModel second_data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel second_response = api.reg.registration(second_data);

        assertThat(second_response.getId()).isEqualTo(firstId + 1);
    }

    @Test
    @DisplayName("Проверка ошибки 400 при повторном использовании поля username и пустого поля password")
    void repeateUsernameAndEmptyPassword() {
        RegistrationFullModel data = new RegistrationFullModel(testData.randomUsername, testData.randomPassword);
        api.reg.registration(data);

        RegistrationFullModel secondData = new RegistrationFullModel(testData.randomUsername, "");
        RegistrationWithoutPasswordAndRepeateUsername resultResponse = api.reg
                .registrationWithoutPassAndRepeateUsername(secondData);

        assertThat(resultResponse.getUsername()[0]).isEqualTo("A user with that username already exists.");
        assertThat(resultResponse.getPassword()[0]).isEqualTo("This field may not be blank.");
    }

    //Тут используются модели ответов мз прошлых тестов, тк они имеют идентичную структуру
    @Test
    @DisplayName("Проверка корректнгой регистрации пользователя и поля username")
    void epmtyBodyRegistration() {
        RegistrationWithoutPasswordAndRepeateUsername response = api.reg.emptyBodyRegistration();

        assertThat(response.getUsername()[0]).isEqualTo("This field is required.");
        assertThat(response.getUsername()[0]).isEqualTo("This field is required.");
    }


}

package tests.rest.tests;

import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.rest.models.update.request.UpdateFullBodyModel;
import tests.rest.models.update.response.CorrectUpdateResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class UpdateTest extends BaseTest {
    TestData td = new TestData();


    @Test
    void correctUpdateTest() {
        RegistrationFullModel regData = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());

        UpdateFullBodyModel updateData = new UpdateFullBodyModel(
                td.getRandomUsername(),
                td.getRandomFirstName(),
                td.getRandomLastName(),
                td.getRandomEmail());

        SuccessfullRegistrationResponseModel registrationResponse = step(
                "Регистрация пользователя", () -> api.reg.registration(regData));

        SuccessfullLoginResponseModel loginResponse = step("Логин зарегистрированного пользователя", () -> {
            LoginFullBodyModel LoginData = new LoginFullBodyModel(regData.getUsername(), regData.getPassword());
            return api.auth.login(LoginData);
        });

        step("Изменение пользователя и проверки полей", () -> {
            CorrectUpdateResponseModel updateResponse = api.updt.update(updateData, loginResponse.getAccess());

            assertThat(updateResponse.getUsername()).isNotEqualTo(registrationResponse.getUsername());
            assertThat(updateResponse.getFirstName()).isEqualTo(updateData.getFirstName());
            assertThat(updateResponse.getLastName()).isEqualTo(updateData.getLastName());
            assertThat(updateResponse.getEmail()).isEqualTo(updateData.getEmail());
        });

    }
}

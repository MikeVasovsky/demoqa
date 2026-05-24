package tests.booksclub.tests.api.registration;

import org.junit.jupiter.api.Test;
import tests.booksclub.tests.api.BaseTest;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;
import tests.booksclub.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.booksclub.rest.models.update.request.UpdateFullBodyModel;
import tests.booksclub.rest.models.update.response.CorrectUpdateResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.booksclub.rest.data.TestData.returnRandomPassword;
import static tests.booksclub.rest.data.TestData.returnRandomUsername;

public class UpdateTest extends BaseTest {

    @Test
    void correctUpdateTest() {
        RegistrationFullModel regData = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());

        UpdateFullBodyModel updateData = new UpdateFullBodyModel(
                t.getRandomUsername(),
                t.getRandomFirstName(),
                t.getRandomLastName(),
                t.getRandomEmail());

        SuccessfullRegistrationResponseModel registrationResponse = api.reg.registration(regData);

        LoginFullBodyModel LoginData = new LoginFullBodyModel(regData.getUsername(), regData.getPassword());
        SuccessfullLoginResponseModel loginResponse = api.auth.login(LoginData);


        CorrectUpdateResponseModel updateResponse = api.updt.update(updateData, loginResponse.getAccess());
        step("Проверка полей", () -> {
            assertThat(updateResponse.getUsername()).isNotEqualTo(registrationResponse.getUsername());
            assertThat(updateResponse.getFirstName()).isEqualTo(updateData.getFirstName());
            assertThat(updateResponse.getLastName()).isEqualTo(updateData.getLastName());
            assertThat(updateResponse.getEmail()).isEqualTo(updateData.getEmail());
        });
    }
}

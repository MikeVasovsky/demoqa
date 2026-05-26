package tests.booksclub.tests.api.clubs;

import org.junit.jupiter.api.Test;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.put.request.FullPutBodyModel;
import tests.booksclub.rest.models.put.response.CorrectPutResponseModel;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;
import tests.booksclub.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.booksclub.tests.api.BaseTest;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.booksclub.rest.data.TestData.returnRandomPassword;
import static tests.booksclub.rest.data.TestData.returnRandomUsername;

public class PutTest extends BaseTest {

    @Test
    void correctPutTest() {
        RegistrationFullModel regData = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());

        FullPutBodyModel updateData = new FullPutBodyModel(
                t.getRandomUsername(),
                t.getRandomFirstName(),
                t.getRandomLastName(),
                t.getRandomPassword(),
                t.getRandomEmail());

        SuccessfullRegistrationResponseModel registrationResponse = api.reg.registration(regData);

        LoginFullBodyModel LoginData = new LoginFullBodyModel(regData.getUsername(), regData.getPassword());
        SuccessfullLoginResponseModel loginResponse = api.auth.login(LoginData);

        CorrectPutResponseModel updateResponse = api.put.put(updateData, loginResponse.getAccess());
        step("Проверки ответа", () -> {
            assertThat(updateResponse.getUsername()).isNotEqualTo(registrationResponse.getUsername());
            assertThat(updateResponse.getFirstName()).isEqualTo(updateData.getFirstName());
            assertThat(updateResponse.getLastName()).isEqualTo(updateData.getLastName());
            assertThat(updateResponse.getEmail()).isEqualTo(updateData.getEmail());
        });
    }
}
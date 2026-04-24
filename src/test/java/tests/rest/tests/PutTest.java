package tests.rest.tests;

import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.put.request.FullPutBodyModel;
import tests.rest.models.put.response.CorrectPutResponseModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class PutTest extends BaseTest {
    TestData td = new TestData();

    @Test
    void correctPutTest() {
        RegistrationFullModel regData = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel registrationResponse = api.reg.registration(regData);
        LoginFullBodyModel LoginData = new LoginFullBodyModel(regData.getUsername(), regData.getPassword());
        SuccessfullLoginResponseModel loginResponse = api.auth.login(LoginData);

        FullPutBodyModel updateData = new FullPutBodyModel(
                td.getRandomUsername(),
                td.getRandomFirstName(),
                td.getRandomLastName(),
                td.getRandomPassword(),
                td.getRandomEmail());

        CorrectPutResponseModel updateResponse = api.put.put(updateData, loginResponse.getAccess());

        assertThat(updateResponse.getUsername()).isNotEqualTo(registrationResponse.getUsername());
        assertThat(updateResponse.getFirstName()).isEqualTo(updateData.getFirstName());
        assertThat(updateResponse.getLastName()).isEqualTo(updateData.getLastName());
        assertThat(updateResponse.getEmail()).isEqualTo(updateData.getEmail());
    }
}
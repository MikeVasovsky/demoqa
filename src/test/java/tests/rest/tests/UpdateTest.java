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

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class UpdateTest extends BaseTest {
    TestData td = new TestData();

    @Test
    void correctUpdate() {
        RegistrationFullModel regData = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel registrationResponse = api.reg.registration(regData);
        LoginFullBodyModel LoginData = new LoginFullBodyModel(regData.getUsername(), regData.getPassword());
        SuccessfullLoginResponseModel loginResponse = api.auth.login(LoginData);

        UpdateFullBodyModel updateData = new UpdateFullBodyModel(
                td.getRandomUsername(),
                returnRandomUsername(),
                returnRandomUsername(),
                td.getRandomEmail());

        CorrectUpdateResponseModel updateResponse = api.updt.update(updateData, loginResponse.getAccess());

        assertThat(updateResponse.getUsername()).isNotEqualTo(registrationResponse.getUsername());
        assertThat(updateResponse.getFirstName()).isEqualTo(updateData.getFirstname());
        assertThat(updateResponse.getLastName()).isEqualTo(updateData.getLastname());

    }

}

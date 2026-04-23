package tests.rest.tests;

import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.returnRandomPassword;
import static tests.rest.data.TestData.returnRandomUsername;

public class RegistrationTest extends BaseTest {

    @Test
    void succesfullRegistration() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);

        assertThat(response.getUsername()).isEqualTo(data.getUsername());
    }

    @Test
    void testIdAfterRegistration() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel response = api.reg.registration(data);

        int firstId = response.getId();

        RegistrationFullModel second_data = new RegistrationFullModel(returnRandomUsername(), returnRandomPassword());
        SuccessfullRegistrationResponseModel second_response = api.reg.registration(second_data);

        assertThat(second_response.getId()).isEqualTo(firstId + 1);
    }
}

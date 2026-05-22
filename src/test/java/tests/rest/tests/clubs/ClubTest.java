package tests.rest.tests.clubs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.clubs.request.createClub.CreateClubRequest;
import tests.rest.models.clubs.request.getById.GetClubByiDRequest;
import tests.rest.models.clubs.response.createClub.CreateClubCorrectResponse;
import tests.rest.models.clubs.response.getById.GetClubByIdCorrectResponse;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.LOGIN_PASSWORD;
import static tests.rest.data.TestData.returnRandomUsername;

public class ClubTest extends BaseTest {

    public TestData t = new TestData();

    @Test
    @DisplayName("Проверка получения клуба по его id")
    void getClubByIdTest() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(data);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel response = api.auth.login(loginData);

        CreateClubRequest createClubData = t.getNewClubData();

        CreateClubCorrectResponse newClub = api.clubs.createClub(createClubData, response.getAccess());

        GetClubByiDRequest getClubData = new GetClubByiDRequest(newClub.getId());
        GetClubByIdCorrectResponse result = api.clubs.getById(getClubData.getId());

        step("Проверяем id созданного и найденного пользователя", () ->
                assertThat(result.getId()).isEqualTo(newClub.getId()));
    }

    @Test
    @DisplayName("Проверка создания клуба")
    void createClubTest() {
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        CreateClubRequest data = t.getNewClubData();

        CreateClubCorrectResponse createClubData = api.clubs.createClub(data, loginResponse.getAccess());

        step("Проверка соответствия созданного клуба данным, по которым создался клуб");
        assertThat(createClubData.getBookTitle()).isEqualTo(data.getBookTitle());
        assertThat(createClubData.getPublicationYear()).isEqualTo(data.getPublicationYear());

        api.clubs.deleteClub(createClubData.getId(), loginResponse.getAccess());
    }

    @Test
    @DisplayName("Проверка удаления клуба")
    void deleteClubTest() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(data);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        CreateClubRequest createClubReq = t.getNewClubData();

        CreateClubCorrectResponse newClub = api.clubs.createClub(createClubReq, loginResponse.getAccess());

        int resultStatusCode = step("Получение статус кода", () ->
                api.clubs.deleteClub(newClub.getId(), loginResponse.getAccess()));
        step("Проверка статус кода удаления", () ->
                assertThat(resultStatusCode).isEqualTo(204));
    }

    @Test
    @DisplayName("Обновление данных клуба")
    void updateClubTest() {
        RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(data);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        CreateClubRequest createClubReq = t.getNewClubData();

        CreateClubCorrectResponse newClub = api.clubs.createClub(createClubReq, loginResponse.getAccess());

        CreateClubRequest updateClubReq = t.getNewClubData();

        CreateClubCorrectResponse updateClub = api.clubs.updateClub(updateClubReq, loginResponse.getAccess(), newClub.getId());

        step("Проверка соответствия id у обновленного клуба и его необновленной версией, проверки несоответствия других данных");
        assertThat(updateClub.getId()).isEqualTo(newClub.getId());
        assertThat(updateClub.getBookTitle()).isNotEqualTo(newClub.getBookTitle());
        assertThat(updateClub.getBookAuthors()).isNotEqualTo(newClub.getBookAuthors());
        assertThat(updateClub.getPublicationYear()).isNotEqualTo(newClub.getPublicationYear());
    }
}

package tests.booksclub.tests.api.clubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.booksclub.tests.api.BaseTest;
import tests.booksclub.rest.models.clubs.request.createClub.CreateClubRequest;
import tests.booksclub.rest.models.clubs.request.getById.GetClubByiDRequest;
import tests.booksclub.rest.models.clubs.response.createClub.CreateClubCorrectResponse;
import tests.booksclub.rest.models.clubs.response.getById.GetClubByIdCorrectResponse;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;
import tests.booksclub.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.booksclub.rest.data.TestData.LOGIN_PASSWORD;
import static tests.booksclub.rest.data.TestData.returnRandomUsername;

public class ClubTest extends BaseTest {

    RegistrationFullModel data;
    SuccessfullRegistrationResponseModel newUser;
    LoginFullBodyModel loginData;
    SuccessfullLoginResponseModel loginResponse;
    CreateClubRequest createClubData;
    CreateClubCorrectResponse newClub;

    @BeforeEach
    void registrationAndLoginUser() {
        data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        newUser = api.reg.registration(data);
        loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        loginResponse = api.auth.login(loginData);
    }

    public void createNewClub() {
        createClubData = t.getNewClubData();
        newClub = api.clubs.createClub(createClubData, loginResponse.getAccess());
    }


    @Test
    @DisplayName("Проверка получения клуба по его id")
    void getClubByIdTest() {
        createNewClub();
        GetClubByiDRequest getClubData = new GetClubByiDRequest(newClub.getId());
        GetClubByIdCorrectResponse result = api.clubs.getById(getClubData.getId());

        step("Проверяем id созданного и найденного пользователя", () ->
                assertThat(result.getId()).isEqualTo(newClub.getId()));
    }

    @Test
    @DisplayName("Проверка создания клуба")
    void createClubTest() {
        createNewClub();
        step("Проверка соответствия созданного клуба данным, по которым создался клуб");
        assertThat(newClub.getBookTitle()).isEqualTo(createClubData.getBookTitle());
        assertThat(newClub.getPublicationYear()).isEqualTo(createClubData.getPublicationYear());

        api.clubs.deleteClub(newClub.getId(), loginResponse.getAccess());
    }

    @Test
    @DisplayName("Проверка удаления клуба")
    void deleteClubTest() {
        createNewClub();
        int resultStatusCode = step("Получение статус кода", () ->
                api.clubs.deleteClub(newClub.getId(), loginResponse.getAccess()));
        step("Проверка статус кода удаления", () ->
                assertThat(resultStatusCode).isEqualTo(204));
    }

    @Test
    @DisplayName("Обновление данных клуба")
    void updateClubTest() {
        createNewClub();
        CreateClubRequest updateClubReq = t.getNewClubData();
        CreateClubCorrectResponse updateClub = api.clubs.updateClub(updateClubReq, loginResponse.getAccess(), newClub.getId());

        step("Проверка соответствия id у обновленного клуба и его необновленной версией, проверки несоответствия других данных", () -> {
            assertThat(updateClub.getId()).isEqualTo(newClub.getId());
            assertThat(updateClub.getBookTitle()).isNotEqualTo(newClub.getBookTitle());
            assertThat(updateClub.getBookAuthors()).isNotEqualTo(newClub.getBookAuthors());
            assertThat(updateClub.getPublicationYear()).isNotEqualTo(newClub.getPublicationYear());
        });
    }
}

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
import static tests.rest.data.TestData.*;

public class ClubTest extends BaseTest {

    public TestData t = new TestData();

    @Test
    @DisplayName("Проверка получения клуба по его id")
    void getClubByIdTest() {
        SuccessfullRegistrationResponseModel newUser = step("Корректная регистрация пользователя", () -> {
            RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
            return api.reg.registration(data);
        });

        SuccessfullLoginResponseModel response = step("Логин предустановленного пользователя без регистрации", () -> {
            LoginFullBodyModel data = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
            return api.auth.login(data);
        });

        CreateClubRequest createClubData = new CreateClubRequest(
                t.randomTittle,
                t.randomAuthor,
                t.randomDate,
                t.randomDescription,
                TG_URL
        );

        CreateClubCorrectResponse newClub = step("Создание нового клуба", () ->
                api.clubs.createClub(createClubData, response.getAccess()));


        GetClubByIdCorrectResponse result = step("", () -> {
                    GetClubByiDRequest data = new GetClubByiDRequest(newClub.getId());
                    return api.clubs.getById(data.getId());
                }
        );
        assertThat(result.getId()).isEqualTo(newClub.getId());
    }

    @Test
    @DisplayName("Проверка создания клуба")
    void createClubTest() {
        SuccessfullRegistrationResponseModel newUser = step("Корректная регистрация пользователя", () -> {
            RegistrationFullModel data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
            return api.reg.registration(data);
        });

        SuccessfullLoginResponseModel response = step("Логин предустановленного пользователя без регистрации", () -> {
            LoginFullBodyModel data = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
            return api.auth.login(data);
        });

        CreateClubRequest data = new CreateClubRequest(
                t.randomTittle,
                t.randomAuthor,
                t.randomDate,
                t.randomDescription,
                TG_URL
        );

        CreateClubCorrectResponse result = step("Создание нового клуба", () ->
                api.clubs.createClub(data, response.getAccess()));

        assertThat(result.getBookTitle()).isEqualTo(data.getBookTitle());
        assertThat(result.getPublicationYear()).isEqualTo(data.getPublicationYear());
    }


}

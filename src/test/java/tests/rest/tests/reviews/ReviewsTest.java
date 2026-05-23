package tests.rest.tests.reviews;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.rest.models.reviews.request.createReview.CreateReviewRequest;
import tests.rest.models.reviews.request.getReview.GetReviewRequestData;
import tests.rest.models.reviews.request.putReview.PutReviewRequest;
import tests.rest.models.reviews.response.createReview.CreateReviewResponse;
import tests.rest.models.reviews.response.getReview.GetReviewResponse;
import tests.rest.models.reviews.response.putReview.PutReviewResponse;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.*;

public class ReviewsTest extends BaseTest {

    @Test
    @DisplayName("Получение отзыва")
    void getReviewTest() {
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());

        CreateReviewRequest reviewData = new CreateReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        CreateReviewResponse reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());

        GetReviewRequestData data = new GetReviewRequestData(reviewResult.getClub(), returnRandomReadPages(), returnRandomReadPages());
        GetReviewResponse result = api.reviews.getReview(data);
        step("Проверка полученного отзыва", () ->
                assertThat(result.getResults().getFirst().getReview()).isEqualTo(reviewResult.getReview())
        );
    }

    @Test
    @DisplayName("Создание нового отзыва")
    void createReview() {
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());

        CreateReviewRequest reviewData = new CreateReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        CreateReviewResponse reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());
        step("Проверка ответа нового созданного отзыва", () -> {
            assertThat(reviewResult.getReview()).isEqualTo(reviewData.getReview());
            assertThat(reviewResult.getClub()).isEqualTo(reviewData.getClub());
            assertThat(reviewResult.getReadPages()).isEqualTo(reviewData.getReadPages());
            assertThat(reviewResult.getAssessment()).isEqualTo(reviewData.getAssessment());
        });
    }

    @Test
    @DisplayName("Удаление отзыва")
    void deleteReviewTest(){
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());

        CreateReviewRequest reviewData = new CreateReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        CreateReviewResponse reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());

        int statusCodeResult = api.reviews.deleteReview(reviewResult.getId(), loginResponse.getAccess());
        step("Проверка статус кода удаления отзыва",()->
                assertThat(204).isEqualTo(statusCodeResult));
    }

    @Test
    @DisplayName("Замена отзыва")
    void putClubTest(){
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());

        CreateReviewRequest reviewData = new CreateReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        CreateReviewResponse reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());

        PutReviewRequest putReviewData = new PutReviewRequest(returnRandomAssement(),returnTestClub(),returnRandomReadPages(),returnRandomReview());

        PutReviewResponse putResult = api.reviews.putReview(putReviewData,loginResponse.getAccess(),reviewResult.getId());

        step("Проверка замены данных в отзыве", ()->{
            assertThat(putResult.getId()).isEqualTo(reviewResult.getId());
            assertThat(putResult.getReadPages()).isNotEqualTo(reviewResult.getId());
            assertThat(putResult.getReview()).isNotEqualTo(reviewResult.getId());
            assertThat(putResult.getAssessment()).isNotEqualTo(reviewResult.getAssessment());
        });
    }



    //Доделать
    @Test
    @DisplayName("Проверка вступления в клуб")
    void joinToClubTest() {
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(returnTestClub(), loginResponse.getAccess());
    }
}

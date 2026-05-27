package tests.booksclub.tests.api.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.booksclub.tests.api.BaseTest;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;
import tests.booksclub.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.booksclub.rest.models.reviews.request.createReview.CreateReviewRequest;
import tests.booksclub.rest.models.reviews.request.getReview.GetReviewRequestData;
import tests.booksclub.rest.models.reviews.request.patchReviewRequest.PatchReviewRequest;
import tests.booksclub.rest.models.reviews.request.putReview.PutReviewRequest;
import tests.booksclub.rest.models.reviews.response.createReview.CreateReviewResponse;
import tests.booksclub.rest.models.reviews.response.getReview.GetReviewResponse;
import tests.booksclub.rest.models.reviews.response.patchReviewResponse.PatchReviewResponse;
import tests.booksclub.rest.models.reviews.response.putReview.PutReviewResponse;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.booksclub.rest.data.TestData.*;

public class ReviewsTest extends BaseTest {

    RegistrationFullModel data;
    SuccessfullRegistrationResponseModel newUser;
    LoginFullBodyModel loginData;
    SuccessfullLoginResponseModel loginResponse;
    CreateReviewRequest reviewData;
    CreateReviewResponse reviewResult;

    @BeforeEach
    void registrationAndLoginUser() {
        data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        newUser = api.reg.registration(data);
        loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        loginResponse = api.auth.login(loginData);
    }

    public void createReview() {
        reviewData = new CreateReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());
        reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());
    }

    @Test
    @DisplayName("Получение отзыва")
    void getReviewTest() {
        api.members.joinToClub(returnTestClub(), loginResponse.getAccess());
        createReview();
        GetReviewRequestData data = new GetReviewRequestData(reviewResult.getClub(), 1, 100);
        GetReviewResponse result = api.reviews.getReview(data);
        step("Проверка полученного отзыва", () ->
                assertThat(result.getResults())
                        .filteredOn(r -> r.getId() == reviewResult.getId())
                        .extracting("review")
                        .containsExactly(reviewResult.getReview())
        );
    }

    @Test
    @DisplayName("Создание нового отзыва")
    void createReviewTest() {
        api.members.joinToClub(4, loginResponse.getAccess());
        createReview();
        step("Проверка ответа нового созданного отзыва", () -> {
            assertThat(reviewResult.getReview()).isEqualTo(reviewData.getReview());
            assertThat(reviewResult.getClub()).isEqualTo(reviewData.getClub());
            assertThat(reviewResult.getReadPages()).isEqualTo(reviewData.getReadPages());
            assertThat(reviewResult.getAssessment()).isEqualTo(reviewData.getAssessment());
        });
        api.reviews.deleteReview(reviewResult.getId(), loginResponse.getAccess());
    }

    @Test
    @DisplayName("Удаление отзыва")
    void deleteReviewTest() {
        api.members.joinToClub(4, loginResponse.getAccess());
        createReview();

        int statusCodeResult = api.reviews.deleteReview(reviewResult.getId(), loginResponse.getAccess());
        step("Проверка статус кода удаления отзыва", () ->
                assertThat(204).isEqualTo(statusCodeResult));
    }

    @Test
    @DisplayName("Замена отзыва")
    void putClubTest() {
        api.members.joinToClub(4, loginResponse.getAccess());
        createReview();

        PutReviewRequest putReviewData = new PutReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        PutReviewResponse putResult = api.reviews.putReview(putReviewData, loginResponse.getAccess(), reviewResult.getId());

        step("Проверка замены данных в отзыве", () -> {
            assertThat(putResult.getId()).isEqualTo(reviewResult.getId());
            assertThat(putResult.getReadPages()).isNotEqualTo(reviewResult.getId());
            assertThat(putResult.getReview()).isNotEqualTo(reviewResult.getId());
            assertThat(putResult.getAssessment()).isNotEqualTo(reviewResult.getAssessment());
        });
        api.reviews.deleteReview(reviewResult.getId(), loginResponse.getAccess());
    }

    @Test
    @DisplayName("Редактирование отзыва")
    void patchClubTest() {
        api.members.joinToClub(4, loginResponse.getAccess());
        createReview();

        PatchReviewRequest patchReviewData = new PatchReviewRequest(returnRandomAssement(), returnTestClub(), returnRandomReadPages(), returnRandomReview());

        PatchReviewResponse patchResult = api.reviews.putReview(patchReviewData, loginResponse.getAccess(), reviewResult.getId());

        step("Проверка редактирования данных в отзыве", () -> {
            assertThat(patchResult.getId()).isEqualTo(reviewResult.getId());
            assertThat(patchResult.getReadPages()).isNotEqualTo(reviewResult.getId());
            assertThat(patchResult.getReview()).isNotEqualTo(reviewResult.getId());
            assertThat(patchResult.getAssessment()).isNotEqualTo(reviewResult.getAssessment());
        });
        api.reviews.deleteReview(reviewResult.getId(), loginResponse.getAccess());
    }

    @Test
    @DisplayName("Проверка вступления в клуб")
    void joinToClubTest() {
        int resultStatusCode = api.members.joinToClub(returnTestClub(), loginResponse.getAccess());
        step("Проверка статус кода при вступении в клуб", () ->
                assertThat(resultStatusCode).isEqualTo(204));
    }
}

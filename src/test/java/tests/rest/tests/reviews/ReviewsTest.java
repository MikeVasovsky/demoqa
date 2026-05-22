package tests.rest.tests.reviews;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.rest.BaseTest;
import tests.rest.data.TestData;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;
import tests.rest.models.reviews.request.createReview.CreateReviewRequest;
import tests.rest.models.reviews.response.createReview.CreateReviewResponse;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.rest.data.TestData.LOGIN_PASSWORD;
import static tests.rest.data.TestData.returnRandomUsername;

public class ReviewsTest extends BaseTest {

    TestData t = new TestData();

    @Test
    @DisplayName("Получение отзыва")
    void getReviewTest(){

    }

    @Test
    @DisplayName("Создание нового отзыва")
    void createReview(){
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());

        CreateReviewRequest reviewData = new CreateReviewRequest(5,4,2,t.returnRandomReview());

        CreateReviewResponse reviewResult = api.reviews.createReview(reviewData, loginResponse.getAccess());
        step("Проверка ответа нового созданного отзыва",()->{
            assertThat(reviewResult.getReview()).isEqualTo(reviewData.getReview());
            assertThat(reviewResult.getClub()).isEqualTo(reviewData.getClub());
            assertThat(reviewResult.getReadPages()).isEqualTo(reviewData.getReadPages());
            assertThat(reviewResult.getAssessment()).isEqualTo(reviewData.getAssessment());
        });
    }


    //Доделать
    @Test
    @DisplayName("Проверка вступления в клуб")
    void joinToClubTest(){
        RegistrationFullModel registrationData = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        SuccessfullRegistrationResponseModel newUser = api.reg.registration(registrationData);

        LoginFullBodyModel loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        SuccessfullLoginResponseModel loginResponse = api.auth.login(loginData);

        api.members.joinToClub(4, loginResponse.getAccess());
    }
}

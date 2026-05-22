package tests.rest.api.reviews;

import io.qameta.allure.Step;
import tests.rest.models.reviews.request.createReview.CreateReviewRequest;
import tests.rest.models.reviews.response.createReview.CreateReviewResponse;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.reviews.ReviewsSpec.*;

public class ReviewsClient {

    @Step("Создание отзыва")
    public CreateReviewResponse createReview(CreateReviewRequest data, String accessToken) {
        return given(reviewRequestSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(data)
                .when()
                .post("clubs/reviews/")
                .then()
                .spec(successfullCreateReviewResponseSpec)
                .extract().as(CreateReviewResponse.class);
    }

    @Step("Получение отзыва/ов")
    public
}


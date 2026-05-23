package tests.rest.api.reviews;

import io.qameta.allure.Step;
import tests.rest.models.reviews.request.createReview.CreateReviewRequest;
import tests.rest.models.reviews.request.getReview.GetReviewRequestData;
import tests.rest.models.reviews.request.patchReviewRequest.PatchReviewRequest;
import tests.rest.models.reviews.request.putReview.PutReviewRequest;
import tests.rest.models.reviews.response.createReview.CreateReviewResponse;
import tests.rest.models.reviews.response.getReview.GetReviewResponse;
import tests.rest.models.reviews.response.patchReviewResponse.PatchReviewResponse;
import tests.rest.models.reviews.response.putReview.PutReviewResponse;

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
    public GetReviewResponse getReview(GetReviewRequestData data) {
        return given(reviewRequestSpec)
                .body(data)
                .when()
                .get("clubs/reviews/" + String.format(
                        "?club=%s&page=%s&page_size=%s", data.getClub(), data.getPage(), data.getClub()))
                .then()
                .spec(successfullGetReviewResponseSpec)
                .extract().as(GetReviewResponse.class);
    }

    @Step("Удаление отзыва")
    public int deleteReview(int id, String accessToken) {
        return given(reviewRequestSpec)
                .header("Authorization", "Bearer "+accessToken)

                .when()
                .delete("clubs/reviews/" + id + "/")
                .then()
                .spec(succesfullDeleteReviewResponseSpec)
                .extract().statusCode();
    }

    @Step("Замена отзыва")
    public PutReviewResponse putReview(PutReviewRequest data, String accessToken, int id) {
        return given(reviewRequestSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(data)
                .when()
                .put("clubs/reviews/"+ id + "/")
                .then()
                .spec(successfullPutReviewResponseSpec)
                .extract().as(PutReviewResponse.class);
    }

    @Step("Редактирование отзыва")
    public PatchReviewResponse putReview(PatchReviewRequest data, String accessToken, int id) {
        return given(reviewRequestSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(data)
                .when()
                .patch("clubs/reviews/"+ id + "/")
                .then()
                .spec(successfullPatchReviewResponseSpec)
                .extract().as(PatchReviewResponse.class);
    }
}


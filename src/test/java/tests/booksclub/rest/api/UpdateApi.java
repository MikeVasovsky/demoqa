package tests.booksclub.rest.api;

import io.qameta.allure.Step;
import tests.booksclub.rest.models.update.request.UpdateFullBodyModel;
import tests.booksclub.rest.models.update.response.CorrectUpdateResponseModel;

import static io.restassured.RestAssured.given;
import static tests.booksclub.rest.specs.update.UpdateSpec.*;

public class UpdateApi {

    @Step("Обновление юзера")
    public CorrectUpdateResponseModel update (UpdateFullBodyModel updateFullBodyModel, String accessToken){
        return given(requestSpecification)
                .header("Authorization", "Bearer "+accessToken)
                .body(updateFullBodyModel)
                .when()
                .patch("/users/me/")
                .then()
                .spec(successfullUpdatenResponseSpec)
                .extract().as(CorrectUpdateResponseModel.class);
    }
}

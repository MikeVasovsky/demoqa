package tests.rest.api;

import tests.rest.models.update.request.UpdateFullBodyModel;
import tests.rest.models.update.response.CorrectUpdateResponseModel;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.update.UpdateSpec.*;

public class UpdateApi {

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

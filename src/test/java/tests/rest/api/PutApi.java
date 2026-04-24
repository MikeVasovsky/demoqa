package tests.rest.api;

import tests.rest.models.put.request.FullPutBodyModel;
import tests.rest.models.put.response.CorrectPutResponseModel;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.put.PutSpec.putSpecification;
import static tests.rest.specs.put.PutSpec.successPut;

public class PutApi {

    public CorrectPutResponseModel put (FullPutBodyModel bodyModel, String accessToken){
        return given(putSpecification)
                .header("Authorization", "Bearer "+accessToken)
                .body(bodyModel)
                .when()
                .patch("/users/me/")
                .then()
                .spec(successPut)
                .extract().as(CorrectPutResponseModel.class);
    }
}

package tests.booksclub.rest.api;

import io.qameta.allure.Step;
import tests.booksclub.rest.models.put.request.FullPutBodyModel;
import tests.booksclub.rest.models.put.response.CorrectPutResponseModel;

import static io.restassured.RestAssured.given;
import static tests.booksclub.rest.specs.put.PutSpec.putSpecification;
import static tests.booksclub.rest.specs.put.PutSpec.successPut;

public class PutApi {

    @Step("Обновление клуба")
    public CorrectPutResponseModel put(FullPutBodyModel bodyModel, String accessToken) {
        return given(putSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .body(bodyModel)
                .when()
                .patch("/users/me/")
                .then()
                .spec(successPut)
                .extract().as(CorrectPutResponseModel.class);
    }
}

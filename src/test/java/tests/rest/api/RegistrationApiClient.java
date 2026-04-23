package tests.rest.api;

import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.registration.RegistrationSpec.requestSpecification;
import static tests.rest.specs.registration.RegistrationSpec.successfullRegistrationResponseSpec;

public class RegistrationApiClient {

    public SuccessfullRegistrationResponseModel registration(RegistrationFullModel registrationModel){
        return given(requestSpecification)
                .body(registrationModel)
                .when()
                .post("/users/register/")
                .then()
                .spec(successfullRegistrationResponseSpec)
                .extract().as(SuccessfullRegistrationResponseModel.class);
    }
}

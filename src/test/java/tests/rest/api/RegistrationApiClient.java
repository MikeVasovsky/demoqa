package tests.rest.api;

import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.RegistrationWithoutPasswordAndRepeateUsername;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.registration.RegistrationSpec.*;

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

    public RegistrationWithoutPasswordAndRepeateUsername registrationWithoutPassAndRepeateUsername(RegistrationFullModel registrationModel){
        return given(requestSpecification)
                .body(registrationModel)
                .when()
                .post("/users/register/")
                .then()
                .spec(registrationWithoutPasswordAndRepeateUsername)
                .extract().as(RegistrationWithoutPasswordAndRepeateUsername.class);
    }

    public RegistrationWithoutPasswordAndRepeateUsername emptyBodyRegistration(LogoutBodyModel logoutBody){
        return given(requestSpecification)
                .body(logoutBody)
                .when()
                .post("/users/register/")
                .then()
                .spec(registrationWithoutPasswordAndRepeateUsername)
                .extract().as(RegistrationWithoutPasswordAndRepeateUsername.class);
    }
}

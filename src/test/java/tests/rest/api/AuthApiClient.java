package tests.rest.api;

import tests.rest.models.login.*;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.login.LoginSpecs.*;

public class AuthApiClient {

    public SuccessfulLoginResponseModel login(LoginFullBodyModel loginBody) {
        return given(loginRequestSpec)
                .body(loginBody)
                .when()
                .post("/auth/token/")
                .then()
                .spec(successfullLoginResponseSpec)
                .extract().as(SuccessfulLoginResponseModel.class);
    }

    public LoginByBadLogopassResponseModel badLogopasslogin(LoginFullBodyModel loginBody) {
        return given(loginRequestSpec)
                .body(loginBody)
                .when()
                .post("/auth/token/")
                .then()
                .spec(unauthorizedLoginResponseSpec)
                .extract().as(LoginByBadLogopassResponseModel.class);
    }

    public LoginWithourPasswordResponseModel loginWithoutPassword(LoginBodyWithoutPassword loginBody) {
        return given(loginRequestSpec)
                .body(loginBody)
                .when()
                .post("/auth/token/")
                .then()
                .spec(loginWithoutPasswordSpec)
                .extract().as(LoginWithourPasswordResponseModel.class);
    }
}


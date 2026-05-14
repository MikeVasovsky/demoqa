package tests.rest.api;

import io.qameta.allure.Step;
import tests.rest.models.login.request.LoginBodyWithoutPassword;
import tests.rest.models.login.request.LoginBodyWithoutUsername;
import tests.rest.models.login.request.LoginFullBodyModel;
import tests.rest.models.login.response.*;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.login.LoginSpecs.*;

public class AuthApiClient {

    @Step("Логин пользователя")
    public SuccessfullLoginResponseModel login(LoginFullBodyModel loginBody) {
        return given(loginRequestSpec)
                .body(loginBody)
                .when()
                .post("/auth/token/")
                .then()
                .spec(successfullLoginResponseSpec)
                .extract().as(SuccessfullLoginResponseModel.class);
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

    public LoginBodyWithoutUsernameResponseModel loginWithoutUsername(LoginBodyWithoutUsername loginBody) {
        return given(loginRequestSpec)
                .body(loginBody)
                .when()
                .post("/auth/token/")
                .then()
                .spec(loginWithoutUsernameSpec)
                .extract().as(LoginBodyWithoutUsernameResponseModel.class);
    }
}


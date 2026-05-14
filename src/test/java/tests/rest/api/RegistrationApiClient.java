package tests.rest.api;

import io.qameta.allure.Step;
import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.registration.request.RegistrationFullModel;
import tests.rest.models.registration.response.RegistrationWithoutPasswordAndRepeateUsername;
import tests.rest.models.registration.response.SuccessfullRegistrationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.registration.RegistrationSpec.*;

public class RegistrationApiClient {

    @Step("Регистрация пользователя")
    public SuccessfullRegistrationResponseModel registration(RegistrationFullModel registrationModel) {
        return given(requestSpecification)
                .body(registrationModel)
                .when()
                .post("/users/register/")
                .then()
                .spec(successfullRegistrationResponseSpec)
                .extract().as(SuccessfullRegistrationResponseModel.class);
    }

    @Step("Регистрация пользователя без логина и пароля")
    public RegistrationWithoutPasswordAndRepeateUsername registrationWithoutPassAndRepeateUsername(RegistrationFullModel registrationModel) {
        return given(requestSpecification)
                .body(registrationModel)
                .when()
                .post("/users/register/")
                .then()
                .spec(registrationWithoutPasswordAndRepeateUsername)
                .extract().as(RegistrationWithoutPasswordAndRepeateUsername.class);
    }

    @Step("Регистрация пользователя без тела запроса")
    public RegistrationWithoutPasswordAndRepeateUsername emptyBodyRegistration(LogoutBodyModel logoutBody) {
        return given(requestSpecification)
                .body(logoutBody)
                .when()
                .post("/users/register/")
                .then()
                .spec(registrationWithoutPasswordAndRepeateUsername)
                .extract().as(RegistrationWithoutPasswordAndRepeateUsername.class);
    }
}

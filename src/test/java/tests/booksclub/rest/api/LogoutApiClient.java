package tests.booksclub.rest.api;

import io.qameta.allure.Step;
import tests.booksclub.rest.models.logout.request.LogoutBodyModel;
import tests.booksclub.rest.models.logout.response.EmptyRefreshResponseBody;
import tests.booksclub.rest.models.logout.response.LogoutIfTokenInBlacklist;
import tests.booksclub.rest.models.logout.response.SuccesfullLogoutResponseBody;

import static io.restassured.RestAssured.given;
import static tests.booksclub.rest.specs.logout.LogoutSpec.*;

public class LogoutApiClient {

    @Step("Логаут пользователя")
    public SuccesfullLogoutResponseBody logout(LogoutBodyModel logoutBody) {
        return given(logoutSpecification)
                .body(logoutBody)
                .when()
                .post("/auth/logout/")
                .then()
                .spec(succeslullLogout)
                .extract().as(SuccesfullLogoutResponseBody.class);
    }

    @Step("Повторный логаут пользователя")
    public LogoutIfTokenInBlacklist repeatLogout(LogoutBodyModel logoutBody) {
        return given(logoutSpecification)
                .body(logoutBody)
                .when()
                .post("/auth/logout/")
                .then()
                .spec(repeateLogout)
                .extract().as(LogoutIfTokenInBlacklist.class);
    }

    @Step("Логаут пользователя с пустым тестом запроса")
    public EmptyRefreshResponseBody emptyRefreshLogout(LogoutBodyModel logoutBody) {
        return given(logoutSpecification)
                .body(logoutBody)
                .when()
                .post("/auth/logout/")
                .then()
                .spec(emptyRefreshLogout)
                .extract().as(EmptyRefreshResponseBody.class);
    }
}

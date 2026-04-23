package tests.rest.api;

import tests.rest.models.logout.request.LogoutBodyModel;
import tests.rest.models.logout.response.LogoutIfTokenInBlacklist;
import tests.rest.models.logout.response.SuccesfullLogoutResponseBody;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.logout.LogoutSpec.*;

public class LogoutApiClient {

    public SuccesfullLogoutResponseBody logout(LogoutBodyModel logoutBody){
        return given(logoutSpecification)
                .body(logoutBody)
                .when()
                .post("/auth/logout/")
                .then()
                .spec(succeslullLogout)
                .extract().as(SuccesfullLogoutResponseBody.class);
    }

    public LogoutIfTokenInBlacklist repeatLogout(LogoutBodyModel logoutBody){

        return given(logoutSpecification)
                .body(logoutBody)
                .when()
                .post("/auth/logout/")
                .then()
                .spec(repeateLogout)
                .extract().as(LogoutIfTokenInBlacklist.class);
    }
}

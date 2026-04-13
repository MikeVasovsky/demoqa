package tests.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class WdHubStatusTest extends BaseTest {

    @Test
    void bodySizeTest() {
        given().log().all()
                .auth().basic("user1", "1234")
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "shemas/selenoid_autotests_cloud_wd_hub_status.json"))
                .body("value.ready", is(true))
                .body("value.message", containsString("Selenoid 1.11.3 built at"));
    }

}
package tests.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class StatusTest extends BaseTest{

    @Test
    void getTotalTest() {
        given().log().all()
                .get("/status")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "shemas/json_selenoid_status_shema.json")
                )
                .body("total", is(5));
    }

}

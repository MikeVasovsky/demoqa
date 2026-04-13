package tests.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest extends BaseTest{

    private String requestBody = "{\"desiredCapabilities\":{\"browserName\":\"chrome\",\"" +
            "version\":\"127.0\",\"enableVNC\":true,\"labels\":{\"manual\":\"true\"},\"sessionTimeout\":\"60m\",\"name\":\"Manual session\"}," +
            "\"capabilities\":{\"alwaysMatch\":{\"browserName\":\"chrome\",\"browserVersion\":\"127.0\",\"selenoid:options\":{\"enableVNC\":true,\"sessionTimeout\":\"60m\"," +
            "\"labels\":{\"manual\":\"true\"}}},\"firstMatch\":[{}]}}";

    @Test
    void testCreateSession() {
        Response result = given().log().all()
                .header("Content-type", "application/json")
                .auth().basic("user1", "1234")
                .body(requestBody)
                .post("wd/hub/session")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "shemas/json_selenoid_wd_hub_session_shema.json"))
                .extract().response();

        //Добавил для разнообразия проверок
        assertEquals("chrome", result.jsonPath().get("value.capabilities.browserName"));
    }

    @Test
    void unauthorizedTest() {
         given().log().all()
                .header("Content-type", "application/json")
                .body(requestBody)
                .post("wd/hub/session")
                .then()
                .log().all()
                .statusCode(401);
    }
}

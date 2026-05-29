package tests.booksclub.rest.specs.logout;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;
import static tests.booksclub.rest.specs.BaseSpec.baseRequestSpec;

public class LogoutSpec {
    public static RequestSpecification logoutSpecification = baseRequestSpec;

    public static ResponseSpecification succeslullLogout = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification repeateLogout = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(401)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/logout/repeat_logout_shema.json"))
            .expectBody("detail",notNullValue())
            .expectBody("code",notNullValue())
            .build();

    public static ResponseSpecification emptyRefreshLogout = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/logout/empty_refresh_shema.json"))
            .expectBody("refresh",notNullValue())
            .build();
}

package tests.booksclub.rest.specs.update;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;
import static tests.booksclub.rest.specs.BaseSpec.baseRequestSpec;

public class UpdateSpec {
    public static RequestSpecification requestSpecification = baseRequestSpec;

    public static ResponseSpecification successfullUpdatenResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/update/correct_update_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("username", notNullValue())
            .expectBody("firstName", notNullValue())
            .expectBody("lastName", notNullValue())
            .expectBody("email", notNullValue())
            .expectBody("remoteAddr", notNullValue())
            .build();
}

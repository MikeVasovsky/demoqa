package tests.booksclub.rest.specs.put;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static tests.booksclub.rest.specs.BaseSpec.baseRequestSpec;

public class PutSpec {
    public static RequestSpecification putSpecification = baseRequestSpec;

    public static ResponseSpecification successPut = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/put/correct_full_put_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("username", notNullValue())
            .expectBody("firstName", notNullValue())
            .expectBody("lastName", notNullValue())
            .expectBody("email", notNullValue())
            .expectBody("remoteAddr", notNullValue())
            .build();
}

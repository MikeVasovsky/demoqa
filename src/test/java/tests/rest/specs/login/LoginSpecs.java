package tests.rest.specs.login;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;
import static tests.rest.specs.BaseSpec.baseRequestSpec;

public class LoginSpecs {

    public static RequestSpecification loginRequestSpec = baseRequestSpec;

    public static ResponseSpecification successfullLoginResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/auth/correct_auth_token_shema.json"))
            .expectBody("access", notNullValue())
            .expectBody("refresh", notNullValue())
            .build();


    public static ResponseSpecification unauthorizedLoginResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(401)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/auth/unauthorizer_response_shema.json"))
            .expectBody("detail", notNullValue())
            .build();

    public static ResponseSpecification loginWithoutPasswordSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/auth/auth_without_password_shema.json"))
            .expectBody("password", notNullValue())
            .build();

    public static ResponseSpecification loginWithoutUsernameSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/auth/auth_without_username_shema.json"))
            .expectBody("username", notNullValue())
            .build();
}

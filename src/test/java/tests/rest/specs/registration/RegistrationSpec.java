package tests.rest.specs.registration;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;
import static tests.rest.specs.BaseSpec.baseRequestSpec;

public class RegistrationSpec {

    public static RequestSpecification requestSpecification = baseRequestSpec;


    public static ResponseSpecification successfullRegistrationResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(201)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/registration/registration_correct_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("username", notNullValue())
            .build();

    public static ResponseSpecification registrationWithoutPasswordAndRepeateUsername = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath(
                    "shemas/all/registration/registration_withoutpassord_and_repeate_username_shema.json"))
            .expectBody("username", notNullValue())
            .expectBody("password", notNullValue())
            .build();
}


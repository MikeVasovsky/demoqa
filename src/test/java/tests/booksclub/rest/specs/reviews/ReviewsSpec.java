package tests.booksclub.rest.specs.reviews;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;
import static tests.booksclub.rest.specs.BaseSpec.baseRequestSpec;

public class ReviewsSpec {
    public static RequestSpecification reviewRequestSpec = baseRequestSpec;

    public static ResponseSpecification successfullCreateReviewResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(201)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/review/post_review_correct_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("club", notNullValue())
            .expectBody("user", notNullValue())
            .expectBody("review", notNullValue())
            .expectBody("assessment", notNullValue())
            .expectBody("readPages", notNullValue())
            .expectBody("created", notNullValue())
            .build();

    public static ResponseSpecification successfullPutReviewResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/review/put_review_correct_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("club", notNullValue())
            .expectBody("user", notNullValue())
            .expectBody("review", notNullValue())
            .expectBody("assessment", notNullValue())
            .expectBody("readPages", notNullValue())
            .expectBody("created", notNullValue())
            .expectBody("modified", notNullValue())
            .build();

    public static ResponseSpecification successfullPatchReviewResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/review/patch_review_correct_shema.json"))
            .expectBody("id", notNullValue())
            .expectBody("club", notNullValue())
            .expectBody("user", notNullValue())
            .expectBody("review", notNullValue())
            .expectBody("assessment", notNullValue())
            .expectBody("readPages", notNullValue())
            .expectBody("created", notNullValue())
            .expectBody("modified", notNullValue())
            .build();


    public static ResponseSpecification successfullGetReviewResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath(
                    "booksclub/shemas/all/review/get_review_correct_shema.json"))
            .expectBody("count", notNullValue())
            .expectBody("results", notNullValue())
            .build();

    public static ResponseSpecification succesfullDeleteReviewResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(204)
            .build();

}

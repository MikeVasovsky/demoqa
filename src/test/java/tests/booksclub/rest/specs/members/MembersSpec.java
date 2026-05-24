package tests.booksclub.rest.specs.members;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static tests.booksclub.rest.specs.BaseSpec.baseRequestSpec;

public class MembersSpec {

    public static RequestSpecification membersSpecification = baseRequestSpec;

    public static ResponseSpecification succesJoinToClubSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(204)
            .build();
}

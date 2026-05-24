package tests.booksclub.rest.api;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static tests.booksclub.rest.specs.members.MembersSpec.membersSpecification;
import static tests.booksclub.rest.specs.members.MembersSpec.succesJoinToClubSpec;

public class MembersClient {

    @Step("Вступить в клуб")
    public int joinToClub(int id, String accessToken) {
        return given(membersSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("clubs/" + id + "/members/me/")
                .then()
                .spec(succesJoinToClubSpec)
                .extract().statusCode();
    }
}

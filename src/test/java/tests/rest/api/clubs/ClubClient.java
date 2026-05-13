package tests.rest.api.clubs;

import tests.rest.models.clubs.request.createClub.CreateClubRequest;
import tests.rest.models.clubs.response.createClub.CreateClubCorrectResponse;
import tests.rest.models.clubs.response.getById.GetClubByIdCorrectResponse;

import static io.restassured.RestAssured.given;
import static tests.rest.specs.clubs.ClubsSpec.*;

public class ClubClient {

    public GetClubByIdCorrectResponse getById(int id){
        return given(clubsRequestSpec)
                .get("/clubs/"+id+"/")
                .then()
                .spec(succesfullGetByIdResponseSpec)
                .extract().as(GetClubByIdCorrectResponse.class);
    }

    public CreateClubCorrectResponse createClub(CreateClubRequest model, String accessToken){
        return given(clubsRequestSpec)
                .header("Authorization", "Bearer "+accessToken)
                .body(model)
                .when()
                .post("clubs/")
                .then()
                .spec(succesfullCreateClubSpec)
                .extract().as(CreateClubCorrectResponse.class);
    }

    public int deleteClub(int id, String accessToken){
        return given(clubsRequestSpec)
                .header("Authorization", "Bearer "+accessToken)
                .when()
                .delete("/clubs/"+id+"/")
                .then()
                .spec(succesfullDeleteClubSpec)
                .extract().statusCode();
    }

    public CreateClubCorrectResponse updateClub(CreateClubRequest model, String accessToken, int id){
        return given(clubsRequestSpec)
                .header("Authorization", "Bearer "+accessToken)
                .body(model)
                .when()
                .put("/clubs/"+id+"/")
                .then()
                .spec(succesfullUpdateClubSpec)
                .extract().as(CreateClubCorrectResponse.class);
    }


}

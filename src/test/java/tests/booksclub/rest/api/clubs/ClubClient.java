package tests.booksclub.rest.api.clubs;

import io.qameta.allure.Step;
import tests.booksclub.rest.models.clubs.request.createClub.CreateClubRequest;
import tests.booksclub.rest.models.clubs.response.createClub.CreateClubCorrectResponse;
import tests.booksclub.rest.models.clubs.response.getById.GetClubByIdCorrectResponse;

import static io.restassured.RestAssured.given;
import static tests.booksclub.rest.specs.clubs.ClubsSpec.*;

public class ClubClient {

    @Step("Получить клуб по id")
    public GetClubByIdCorrectResponse getById(int id){
        return given(clubsRequestSpec)
                .get("/clubs/"+id+"/")
                .then()
                .spec(succesfullGetByIdResponseSpec)
                .extract().as(GetClubByIdCorrectResponse.class);
    }

    @Step("Создание клуба")
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

    @Step("Удаление клуба")
    public int deleteClub(int id, String accessToken){
        return given(clubsRequestSpec)
                .header("Authorization", "Bearer "+accessToken)
                .when()
                .delete("/clubs/"+id+"/")
                .then()
                .spec(succesfullDeleteClubSpec)
                .extract().statusCode();
    }

    @Step("Обновление данных клуба")
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

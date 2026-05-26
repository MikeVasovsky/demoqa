package tests.booksclub.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.booksclub.pages.ClubsPage;
import tests.booksclub.pages.OpenClubPage;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;

public class ClubsTest extends BaseTest {
    ClubsPage clubs = new ClubsPage();
    OpenClubPage openClubPage = new OpenClubPage();


    @Test
    @DisplayName("Проверка отображения названия созданного клуба")
    public void openMainPageAfterLoginTest() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle());
    }

    @Test
    @DisplayName("Проверка вступления в клуб")
    public void joinClubTest() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle())
                .joinClub()
                .checkClubData(createClubData);
    }

    @Test
    @DisplayName("Проверка выхода из клуба")
    public void exitFromClub() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle())
                .openClub();

        openPageWithNewCreateUser();
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle())
                .joinClub();

        openClubPage.exitFromClub();
        clubs.searchClub(createClubData.getBookTitle())
                .checkJoinClubBtn();
    }
}

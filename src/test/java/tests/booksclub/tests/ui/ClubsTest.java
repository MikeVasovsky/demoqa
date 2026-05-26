package tests.booksclub.tests.ui;

import org.junit.jupiter.api.Test;
import tests.booksclub.pages.ClubsPage;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;

public class ClubsTest extends BaseTest {
    ClubsPage clubs = new ClubsPage();

    @Test
    public void openMainPageAfterLoginTest() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle());
    }

    @Test
    public void joinClubTest() {
        SuccessfullLoginResponseModel loginResponse = openPageWithNewCreateUser();
        createNewClub(loginResponse.getAccess());
        clubs.openClubPage()
                .searchClub(createClubData.getBookTitle())
                .joinClub()
                .checkClubData(createClubData.getBookAuthors(),
                        createClubData.getBookTitle(),
                        createClubData.getPublicationYear());
    }
}

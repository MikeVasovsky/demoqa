package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.booksclub.rest.models.clubs.request.createClub.CreateClubRequest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;
import static java.lang.String.valueOf;

public class OpenClubPage {
    private SelenideElement clubContainer = $(".club-content");
    private SelenideElement exitClubBtn = $(".leave-btn");


    @Step("Проверить данные клуба")
    public OpenClubPage checkClubData(CreateClubRequest newClub) {
        clubContainer.find(".authors").shouldHave(text("Автор(ы): " + newClub.getBookAuthors()));
        clubContainer.find(".club-header h1").shouldHave(text(newClub.getBookTitle()));
        clubContainer.find(".year").shouldHave(text(valueOf(newClub.getPublicationYear())));
        return this;
    }

    @Step("Выйти из клуба")
    public ClubsPage exitFromClub(){
        exitClubBtn.click();
        confirm();
        return new ClubsPage();
    }

}

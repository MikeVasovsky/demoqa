package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ClubsPage {
    private SelenideElement searchClubFld = $(".search-input");
    private SelenideElement searchBtn = $(".search-button");
    private SelenideElement clubContainer = $(".club-card");
    private SelenideElement openClubBtn = $(".open-btn");


    public ClubsPage openClubPage() {
        open("");
        return this;
    }

    public ClubsPage searchClub(String clubName) {
        searchClubFld.sendKeys(clubName);
        searchBtn.click();
        clubContainer.shouldHave(text(clubName));
        return this;
    }

    public OpenClubPage joinClub() {
        openClubBtn.click();
        return new OpenClubPage();
    }

}

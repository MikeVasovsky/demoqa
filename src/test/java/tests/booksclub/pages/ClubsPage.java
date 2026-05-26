package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.booksclub.pages.components.MainTittle;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ClubsPage {
    MainTittle mainTittle = new MainTittle();
    private SelenideElement searchClubFld = $(".search-input");
    private SelenideElement searchBtn = $(".search-button");
    private SelenideElement clubContainer = $(".club-card");
    private SelenideElement joinClubBtn = $(".join-btn");
    private SelenideElement openClubBtn = $(".open-btn");

    @Step("Открыть страницу со всеми клубами")
    public ClubsPage openClubPage() {
        open("");
        return this;
    }

    @Step("Найти клуб")
    public ClubsPage searchClub(String clubName) {
        searchClubFld.sendKeys(clubName);
        searchBtn.click();
        clubContainer.shouldHave(text(clubName));
        return this;
    }

    @Step("Присоединиться к клубу")
    public OpenClubPage joinClub() {
        joinClubBtn.click();
        return new OpenClubPage();
    }

    @Step("Открыть клуб")
    public OpenClubPage openClub(){
        openClubBtn.click();
        return new OpenClubPage();
    }

    @Step("Открыть страницу профиля")
    public ProfilePage goToProfilePage() {
        mainTittle.clickOnProfileBtn();
        return new ProfilePage();
    }

    @Step("Проверить наличие и и текст кнопки 'Присоединиться'")
    public void checkJoinClubBtn(){
        joinClubBtn.shouldBe(visible);
        joinClubBtn.shouldHave(text("Присоединиться"));
    }
}

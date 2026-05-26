package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class OpenClubPage {
    private SelenideElement clubContainer = $(".club-content");

    public OpenClubPage checkClubData(String author,
                                      String tittle,
                                      int year) {
        clubContainer.find(".authors").shouldHave(text("Автор(ы): " + author));
        clubContainer.find(".club-header h1").shouldHave(text(tittle));
        clubContainer.find(".year").shouldHave(text(valueOf(year)));
        return this;
    }

}

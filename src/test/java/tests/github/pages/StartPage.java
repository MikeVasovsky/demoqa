package tests.github.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement searchRepoBtn = $("[class='search-input']");
    private SelenideElement searchRepoFld = $("#query-builder-test");

    public RepositoriesSearchPage searchRepo(String name){
        searchRepoBtn.click();
        searchRepoFld.setValue(name);
        searchRepoFld.pressEnter();
        return new RepositoriesSearchPage();
    }
}

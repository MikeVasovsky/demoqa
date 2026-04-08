package tests.github.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {
    private SelenideElement issueTab = $("#issues-tab");
    private SelenideElement issue;


    public RepositoryPage clickIssueTab(){
        issueTab.click();
        return this;
    }

    public void findIssueByName(String name){
        issue = $(byText(name));
        issue.shouldHave(text(name));
    }
}

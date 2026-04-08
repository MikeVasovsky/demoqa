package tests.github;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepTest {
    private SelenideElement searchRepoBtn = $("[class='search-input']");
    private SelenideElement searchRepoFld = $("#query-builder-test");
    private SelenideElement issueTab = $("#issues-tab");
    private SelenideElement issue;
    private SelenideElement repository;

    private final String URL = "https://github.com/";
    private final String REPOSITORY = "MikeVasovsky/demoqa";
    private final String ISSUENAME = "issue for allure homework";

    @Step("Открываем главную страницу")
    public void openPage() {
        open(URL);
    }

    @Step("Ищем репозиторий {name}")
    public void searchRepo(String name) {
        searchRepoBtn.click();
        searchRepoFld.setValue(name);
        searchRepoFld.pressEnter();
    }

    @Step("Выбираем репозиторий {linkText}")
    public void chooseRepository(String linkText) {
        repository = $(linkText(linkText));
        repository.click();

    }

    @Step("Кликаем на вкладку issue")
    public void clickIssueTab() {
        issueTab.click();
    }

    @Step("Находим issue по имени и проверяем его по имени {name}")
    public void findIssueByName(String name) {
        issue = $(byText(name));
        issue.shouldHave(text(name));
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Нахождение issue")
    @Owner("ikrylov")
    @DisplayName("Проверка issue через steps")
    void checkIssueNameByText() {
        openPage();
        searchRepo(REPOSITORY);
        chooseRepository(REPOSITORY);
        clickIssueTab();
        findIssueByName(ISSUENAME);
    }
}

package tests.github;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.github.pages.RepositoriesSearchPage;
import tests.github.pages.RepositoryPage;
import tests.github.pages.StartPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class AllureLoggerStepsTest extends TestBase {
    StartPage sp = new StartPage();
    RepositoriesSearchPage rsp = new RepositoriesSearchPage();
    RepositoryPage rp = new RepositoryPage();

    @Test
    @Feature("Issue в репозитории")
    @Story("Нахождение issue")
    @Owner("ikrylov")
    @DisplayName("Проверка issue по тексту с шагами через лямбды")
    void checkIssueNameByText() {
        step("Найти репозиторий", () ->
                sp.searchRepo("MikeVasovsky/demoqa"));
        step("Выбрать репозиторий", () ->
                rsp.chooseRepository("MikeVasovsky/demoqa"));
        step("Кликнуть на раздел issue", () ->
                rp.clickIssueTab());
        step("Найти issue и проверить его название", () ->
                rp.findIssueByName("issue for allure homework"));
    }
}

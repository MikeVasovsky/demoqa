package tests.github;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.github.pages.RepositoriesSearchPage;
import tests.github.pages.RepositoryPage;
import tests.github.pages.StartPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class LoggerStepsTest extends TestBase {
    StartPage sp = new StartPage();
    RepositoriesSearchPage rsp = new RepositoriesSearchPage();
    RepositoryPage rp = new RepositoryPage();

    @Test
    @DisplayName("Проверка issue по тексту с шагами через лямбды")
    void checkIssueNameByText() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Найти репозиторий", () -> {
            sp.searchRepo("MikeVasovsky/demoqa");
        });
        step("Выбрать репозиторий", () -> {
            rsp.chooseRepository("MikeVasovsky/demoqa");
        });
        step("Кликнуть на раздел issue", () -> {
            rp.clickIssueTab();
        });
        step("Найти issue и проверить его название", () -> {
            rp.findIssueByName("issue for allure homework");

        });
    }
}

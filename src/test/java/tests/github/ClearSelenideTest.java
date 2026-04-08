package tests.github;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.github.pages.StartPage;

public class ClearSelenideTest extends TestBase {
    StartPage sp = new StartPage();

    @Test
    @Feature("Issue в репозитории")
    @Story("Нахождение issue")
    @Owner("ikrylov")
    @DisplayName("Проверка issue по тексту на чистом selenide")
    void checkIssueNameByText() {
        sp.searchRepo("MikeVasovsky/demoqa")
                .chooseRepository("MikeVasovsky/demoqa")
                .clickIssueTab()
                .findIssueByName("issue for allure homework");
    }
}

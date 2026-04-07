package tests.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.github.pages.StartPage;

public class ClearSelenideTest extends TestBase{
    StartPage sp = new StartPage();

    @Test
    @DisplayName("Проверка issue по тексту на чистом selenide")
    void checkIssueNameByText(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        sp.searchRepo("MikeVasovsky/demoqa")
                .chooseRepository("MikeVasovsky/demoqa")
                .clickIssueTab()
                .findIssueByName("issue for allure homework");
    }
}

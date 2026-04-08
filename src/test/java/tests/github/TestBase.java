package tests.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }


    @BeforeEach
    public void openPage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Открываем страницу github", () ->
                open(baseUrl));
    }

    @AfterEach
    void afterTest() {
        closeWebDriver();
    }
}
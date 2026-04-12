package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.helpers.Attach;

import static io.qameta.allure.Allure.step;
import static java.lang.Boolean.parseBoolean;

public class TestBase {
    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        Configuration.browserSize = System.getProperty("brSize");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserVersion = System.getProperty("brVersion");
        Configuration.remote = System.getProperty("remote");
        Configuration.headless = parseBoolean(System.getProperty("headless"));
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserCapabilities = options;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterTest() {
        step("приложить вложения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
        });
        step("закрыть браузер", Selenide::closeWebDriver);
    }
}
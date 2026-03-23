package tests.duolingo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://ko.duolingo.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 1000;
    }

    @AfterEach
    void afterTest() {
        closeWebDriver();
    }
}
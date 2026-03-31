package tests.duolingo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://ko.duolingo.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }


    @BeforeEach
    public void openPage() {
        open(baseUrl);
    }

    @AfterEach
    void afterTest() {
        closeWebDriver();
    }
}
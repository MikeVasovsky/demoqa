package tests.duolingo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.duolingo.pages.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest extends TestBase {

    @BeforeEach
    public void openPage() {
        open(baseUrl);
    }

    MainPage mainPage = new MainPage();

    @ParameterizedTest
    @DisplayName("Проверка изменения приветственного сообщения, при изменении языка сайта")
    @CsvSource(value = {
            "English; The free, fun, and effective way to learn a language!",
            "Deutsch; Effektiv und kostenlos eine Sprache lernen – und dabei Spaß haben!",
    }, delimiter = ';')
    public void greetengsElementShouldChangeLanguageThenLanguageIsChanges(String l, String result) {
        mainPage.changeLanguage(l);
        assertEquals(result, mainPage.getTextFromGreetingsTitle());
    }
}

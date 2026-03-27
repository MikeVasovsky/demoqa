package tests.duolingo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import tests.demoqa.testdata.TestData;
import tests.duolingo.pages.LearnLanguages;
import tests.duolingo.pages.LoginPage;
import tests.duolingo.pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends TestBase {

    @BeforeEach
    public void openPage() {
        open(baseUrl);
    }

    MainPage mainPage = new MainPage();

    private static Stream<Arguments> checkErrorMessageIfLogopassIncorrect() {
        TestData t = new TestData();
        return Stream.of(
                Arguments.of(t.getF().internet().emailAddress(), t.getF().internet().password()),
                Arguments.of(t.getF().internet().emailAddress(), t.getF().internet().password()),
                Arguments.of(t.getF().internet().emailAddress(), t.getF().internet().password())
        );
    }

    @ParameterizedTest
    @DisplayName("Проверка изменения приветственного сообщения, при изменении языка сайта")
    @CsvSource(value = {
            "English; The free, fun, and effective way to learn a language!",
            "Deutsch; Effektiv und kostenlos eine Sprache lernen – und dabei Spaß haben!",
    }, delimiter = ';')
    public void greetengsElementShouldChangeLanguageThenLanguageIsChanges(String l, String result) {
        mainPage.changeSiteLanguage(l);
        assertEquals(result, mainPage.getTextFromGreetingsTitle());
    }

    @ParameterizedTest
    @DisplayName("Проверка выбора изучаемого языка")
    @EnumSource(LearnLanguages.class)
    void checkMessageThenChooseLearnLanguage(LearnLanguages l) {
        mainPage.changeSiteLanguage("русский")
                .acceptCookie()
                .changeLearnLanguage(l.getLanguage());
        assertEquals(l.getDesc(), mainPage.getTextFromGreetingsTitle());

    }

    @ParameterizedTest
    @DisplayName("Проверка логина с некорреткными логином и паролем")
    @MethodSource("checkErrorMessageIfLogopassIncorrect")
    void checkErrorMessageIfLogopassIncorrect(String email, String password) {
        String result = mainPage.changeSiteLanguage("русский")
                .acceptCookie()
                .goToLoginPage()
                .loginWithIncorrectLogopass(email, password);
        assertTrue(result.contains("Повторите попытку."));
    }
}

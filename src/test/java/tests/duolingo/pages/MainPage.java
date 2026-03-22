package tests.duolingo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.duolingo.pages.components.LanguageTittle;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private ElementsCollection languages = $$("._26cAT");
    private SelenideElement greetingsTitle = $(".L93Ok");

    LanguageTittle languageTittle = new LanguageTittle();

    public void changeLanguage(String l) {
        languageTittle.hoverToElement();
        SelenideElement language = languages.findBy(text(l));
        language.click();
    }

    public String getTextFromGreetingsTitle() {
        return greetingsTitle.getText();
    }

}

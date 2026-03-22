package tests.duolingo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private ElementsCollection languages = $$("._26cAT");
    private SelenideElement changeLanguage = $("[class=\"tFegI _1-AxT\"]");
    private SelenideElement greetingsTitle = $(".L93Ok");

    public void changeLanguage(String l){
        changeLanguage.hover();
        SelenideElement language = languages.findBy(text(l));
        language.click();
    }

    public String getTextFromGreetingsTitle(){
        return greetingsTitle.getText();
    }

}

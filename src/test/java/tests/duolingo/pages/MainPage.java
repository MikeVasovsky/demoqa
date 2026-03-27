package tests.duolingo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.duolingo.pages.components.LanguageTittle;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private ElementsCollection siteLanguage = $$("._26cAT");
    private ElementsCollection learnLanguages = $$("._1nZQi");
    private SelenideElement greetingsTitle = $(".L93Ok");
    private SelenideElement acceptCookies = $x("//button[contains(text(),'ACCEPT COOKIES')]");
    private SelenideElement iHaveAccountBtn = $("[data-test='have-account']");
    LanguageTittle languageTittle = new LanguageTittle();


    public MainPage changeSiteLanguage(String l) {
        languageTittle.hoverToElement();
        SelenideElement language = siteLanguage.findBy(text(l));
        language.click();
        return this;
    }

    public void changeLearnLanguage(String l) {
        SelenideElement language = learnLanguages.findBy(text(l));
        language.click();
    }

    public MainPage acceptCookie() {
        if (acceptCookies.exists()){
        acceptCookies.click();
        }
        return this;
    }

    public LoginPage goToLoginPage(){
        iHaveAccountBtn.click();
        return new LoginPage();
    }

    public String getTextFromGreetingsTitle() {
        return greetingsTitle.getText();
    }
}

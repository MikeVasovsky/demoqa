package tests.duolingo.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LanguageTittle {
    private SelenideElement changeLanguage = $("[class='tFegI _1-AxT']");

    public void hoverToElement() {
        changeLanguage.hover();
    }
}

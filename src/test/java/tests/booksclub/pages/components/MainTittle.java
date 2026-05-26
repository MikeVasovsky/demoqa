package tests.booksclub.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainTittle {
    private SelenideElement menuBtn = $(".burger-menu");
    private SelenideElement profileBtn = $("[data-testid='profile-link']");
    private SelenideElement logo = $(".default-logo");


    @Step("Нажать на кнопку профиля")
    public void clickOnProfileBtn() {
        if (menuBtn.isDisplayed()) {
            menuBtn.click();
        }
        profileBtn.click();
    }


}

package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private SelenideElement loginValue = $(".value");

    @Step("Проверка отображения логина на странице профиля")
    public void checkCorrectLoginInProfilePage(RegistrationFullModel data){
        loginValue.shouldHave(text(data.getUsername()));
    }
}

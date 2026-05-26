package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class LoginPage {
    private SelenideElement loginFld = $("#username");
    private SelenideElement passwordFld = $("#password");
    private SelenideElement enterBtn = $(".submit-btn");

    @Step("Открыть страницу логина")
    public LoginPage openLoginPage(){
        open("/signin");
        return this;
    }

    @Step("Авторизация по логину и паролю")
    public ClubsPage correctLogin(String login, String password){
        loginFld.setValue(login);
        passwordFld.setValue(password);
        enterBtn.click();
        return new ClubsPage();
    }


}

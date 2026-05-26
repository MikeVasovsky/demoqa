package tests.booksclub.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import tests.duolingo.pages.MainPage;

import static com.codeborne.selenide.Selenide.$;

@Data
public class LoginPage extends BasePage{
    private SelenideElement loginFld = $("#username");
    private SelenideElement passwordFld = $("#password");
    private SelenideElement enterBtn = $(".submit-btn");

    public MainPage correctLogin(String login, String password){
        loginFld.setValue(login);
        passwordFld.setValue(password);
        enterBtn.click();
        return new MainPage();
    }

}

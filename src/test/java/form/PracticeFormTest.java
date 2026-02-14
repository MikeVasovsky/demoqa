package form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void correctRegistration() {
        open(baseUrl+"/automation-practice-form");
        $("#firstName").setValue("ivan");
        $("#lastName").setValue("ivanov");
        $("#userEmail").setValue("ivanov@gmail.com");
        $("#userNumber").setValue("89990007766");
        $("#genterWrapper").$(byText("Female")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='2025']").click();
        $(".react-datepicker__month-select").click();
        $("[value='4']").click();
        $("[aria-label='Choose Sunday, May 11th, 2025']").click();
        $("#subjectsInput").setValue("arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("sample-clouds-400x300.jpg");
        $("#currentAddress").setValue("my_current_address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        //Блок проверки результата
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("ivan ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("ivanov@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999000776"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 May,2025"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sport"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("sample-clouds-400x300.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("my_current_address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}

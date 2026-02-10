package form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    File downloadFile = new File("src/test/resources/sample-clouds-400x300.jpg");

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void correctRegistration() {
        open(baseUrl);
        $("#firstName").setValue("ivan");
        $("#lastName").setValue("ivanov");
        $("#userEmail").setValue("ivanov@gmail.com");
        executeJavaScript("arguments[0].click();", $("label[for='gender-radio-1']"));
        $("#userNumber").setValue("89990007766");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").setValue("10 Feb 2026");
        $("#subjectsInput").sendKeys("a");
        $("#react-select-2-option-2").click();
        executeJavaScript("arguments[0].click();", $("label[for='hobbies-checkbox-1']"));
        $("#uploadPicture").uploadFile(downloadFile);
        $("#currentAddress").setValue("my_current_address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        //Блок проверки результата
        $x("//tbody/tr[1]/td[2]").shouldHave(text("ivan ivanov"));
        $x("//tbody/tr[2]/td[2]").shouldHave(text("ivanov@gmail.com"));
        $x("//tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("//tbody/tr[4]/td[2]").shouldHave(text("8999000776"));
        $x("//tbody/tr[5]/td[2]").shouldHave(text("10 February,202610"));
        $x("//tbody/tr[6]/td[2]").shouldHave(text("Arts"));
        $x("//tbody/tr[7]/td[2]").shouldHave(text("Sport"));
        $x("//tbody/tr[8]/td[2]").shouldHave(text("sample-clouds-400x300.jpg"));
        $x("//tbody/tr[9]/td[2]").shouldHave(text("my_current_address"));
        $x("//tbody/tr[10]/td[2]").shouldHave(text("NCR Delhi"));
    }
}

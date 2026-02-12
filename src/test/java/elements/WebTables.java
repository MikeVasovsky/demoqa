package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTables {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com/webtables";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void formStayIfOneFieldIsEmpty() {
        open(baseUrl);
        $("#addNewRecordButton").click();
        $("#firstName").setValue("name");
        $("#age").setValue("33");
        $("#salary").setValue("33");
        $("#department").setValue("dep");
        $("#submit").click();

        $("#registration-form-modal").shouldBe(visible);
    }
}

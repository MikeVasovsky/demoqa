package elements;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class WebTables extends tests.TestBase {

    @Test
    void formStayIfOneFieldIsEmpty() {
        open(baseUrl+ "/webtables");
        $("#addNewRecordButton").click();
        $("#firstName").setValue(firstName);
        $("#age").setValue("33");
        $("#salary").setValue("33");
        $("#department").setValue("dep");
        $("#submit").click();

        $("#registration-form-modal").shouldBe(visible);
    }
}

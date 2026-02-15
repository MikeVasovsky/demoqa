package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static tests.testdata.TestData.*;

public class WebTables extends TestBase {

    @Test
    void formStayIfOneFieldIsEmptyTest() {
        open("");
        $$(".card-body").findBy(text("Elements")).click();
        $$(".router-link").findBy(text("Web Tables")).click();
        $("#addNewRecordButton").click();
        $("#firstName").setValue(firstName);
        $("#age").setValue(badAge);
        $("#salary").setValue(badSalary);
        $("#department").setValue(badDepartament);
        $("#submit").click();

        $("#registration-form-modal").shouldBe(visible);
    }
}

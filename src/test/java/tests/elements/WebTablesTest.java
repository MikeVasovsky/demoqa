package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.WebTablesPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static tests.testdata.TestData.*;

public class WebTablesTest extends TestBase {

    public WebTablesPage webTablesPage = new WebTablesPage();

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

    @Test
    void checkSuccessAddWebTable(){
        webTablesPage.openPage()
                .clickAddRecordBtn()
                .setFirstname(firstName)
                .setLastname(lastName)
                .setEmail(userEmail)
                .setAge(age)
                .setSalary(salary)
                .setDepartament(departament)
                .clickSubmit()
                .checkWebTableHaveValue(expectedResultInWebTable);
    }
}

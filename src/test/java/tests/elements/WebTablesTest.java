package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.WebTablesPage;

import static tests.testdata.TestData.*;

public class WebTablesTest extends TestBase {

    public WebTablesPage webTablesPage = new WebTablesPage();

    @Test
    void formStayIfOneFieldIsEmptyTest() {
        webTablesPage.openPage()
                .clickAddRecordBtn()
                .setFirstname(firstName)
                .setLastname(lastName)
                .setAge(age)
                .setSalary(salary)
                .setDepartament(departament)
                .clickSubmit()
                .registrationFormShouldBeVisible();
    }

    @Test
    void checkSuccessAddWebTable() {
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

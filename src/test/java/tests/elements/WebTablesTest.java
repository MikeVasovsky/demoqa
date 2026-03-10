package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.WebTablesPage;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class WebTablesTest extends TestBase {

    public WebTablesPage webTablesPage = new WebTablesPage();
    public TestData t = new TestData();

    @Test
    void formStayIfOneFieldIsEmptyTest() {
        webTablesPage.openPage()
                .removeBanner()
                .clickAddRecordBtn()
                .setFirstname(t.getFirstName())
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
                .setFirstname(t.getFirstName())
                .setLastname(t.getLastName())
                .setEmail(t.getUserEmail())
                .setAge(age)
                .setSalary(salary)
                .setDepartament(departament)
                .clickSubmit()
                .checkWebTableHaveValue(expectedResultInWebTable);
    }
}

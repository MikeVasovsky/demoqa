package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.WebTablesPage;
import tests.testdata.TestData;

public class WebTablesTest extends TestBase {

    public WebTablesPage webTablesPage = new WebTablesPage();
    public TestData t = new TestData();

    @Test
    void formStayIfOneFieldIsEmptyTest() {
        webTablesPage.openPage()
                .removeBanner()
                .clickAddRecordBtn()
                .setFirstname(t.firstName)
                .setLastname(t.lastName)
                .setAge(null)
                .setSalary(t.salary)
                .setDepartament(t.departament)
                .clickSubmit()
                .registrationFormShouldBeVisible();
    }
}

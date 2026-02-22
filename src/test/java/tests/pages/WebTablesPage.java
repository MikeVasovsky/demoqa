package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    private SelenideElement addRecordBtn = $("#addNewRecordButton");
    private SelenideElement firstnameInput = $("#firstName");
    private SelenideElement lastnameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement ageInput = $("#age");
    private SelenideElement salaryInput = $("#salary");
    private SelenideElement departmentInput = $("#department");
    private SelenideElement submitBtn = $("#submit");
    private SelenideElement resultFld = $(".container-fluid");
    private SelenideElement registrrationForm = $("#registration-form-modal");

    public WebTablesPage openPage() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Elements")).click();
        $$(".router-link").findBy(text("Web Tables")).click();
        return this;
    }

    public WebTablesPage setFirstname(String value) {
        firstnameInput.setValue(value);
        return this;
    }

    public WebTablesPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public WebTablesPage setLastname(String value) {
        lastnameInput.setValue(value);
        return this;
    }

    public WebTablesPage setAge(String value) {
        ageInput.setValue(value);
        return this;
    }

    public WebTablesPage setSalary(String value) {
        salaryInput.setValue(value);
        return this;
    }

    public WebTablesPage setDepartament(String value) {
        departmentInput.setValue(value);
        return this;
    }

    public WebTablesPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public WebTablesPage clickAddRecordBtn() {
        addRecordBtn.click();
        return this;
    }

    public void checkWebTableHaveValue(String... value) {
        for (String s : value) {
            resultFld.shouldHave(text(s));
        }
    }

    public void registrationFormShouldBeVisible() {
        registrrationForm.shouldBe(visible);
    }
}

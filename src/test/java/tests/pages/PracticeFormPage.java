package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;
import tests.pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement genderWrapperBtn = $("#genterWrapper");
    private SelenideElement dateInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapperBtn = $("#hobbiesWrapper");
    private SelenideElement uploadPictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#react-select-3-input");
    private SelenideElement cityInput = $("#react-select-4-input");
    private SelenideElement submitBtn = $("#submit");

    public PracticeFormPage openPage() {
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        return this;
    }

    public PracticeFormPage removeBanner() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapperBtn.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setDateOfBirth(Integer day, String month, String year) {
        dateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value)
                .pressEnter();
        return this;
    }

    public PracticeFormPage setHobbie(String value) {
        hobbiesWrapperBtn.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public PracticeFormPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public PracticeFormPage checkResult(String tab, String value) {
        tableResultComponent.checkResult(tab, value);
        return this;
    }
}


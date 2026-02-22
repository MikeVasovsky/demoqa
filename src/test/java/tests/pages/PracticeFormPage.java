package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement genderWrapperBtn = $("#genterWrapper");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement monthInput = $(".react-datepicker__month-select");
    private SelenideElement yearInput = $(".react-datepicker__year-select");
    private SelenideElement dayInput = $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapperBtn = $("#hobbiesWrapper");
    private SelenideElement uploadPictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#react-select-3-input");
    private SelenideElement cityInput = $("#react-select-4-input");
    private SelenideElement submitBtn = $("#submit");
    private SelenideElement resultTab = $(".table-responsive");

    public PracticeFormPage openPage() {
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
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

    public PracticeFormPage setMonth(String value) {
        dateOfBirthInput.click();
        monthInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setYear(String value) {
        dateOfBirthInput.click();
        yearInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setDay(String value) {
        dateOfBirthInput.click();
        dayInput = $(".react-datepicker__day--" + value + ":not(.react-datepicker__day--outside-month)");
        dayInput.click();
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

    public void checkResult(String[] tab, String[] result) {
        for (int i = 0; i < tab.length; i++) {
            resultTab.$(byText(tab[i])).parent().shouldHave(text(result[i]));
        }
    }
}


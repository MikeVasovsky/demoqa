package tests.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.demoqa.pages.components.CalendarComponent;
import tests.demoqa.pages.components.TableResultComponent;

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

    @Step("удалил баннер, если он отображается")
    public PracticeFormPage removeBanner() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }

    @Step("ввести имя {value}")
    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("ввести фамилию {value}")
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("ввести email {value}")
    public PracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("ввести номер телефона {value}")
    public PracticeFormPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("ввести пол {value}")
    public PracticeFormPage setGender(String value) {
        genderWrapperBtn.$(byText(value)).click();
        return this;
    }

    @Step("ввести дату рождения {day}, {month}, {year}")
    public PracticeFormPage setDateOfBirth(Integer day, String month, String year) {
        dateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("ввести предмет {value}")
    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value)
                .pressEnter();
        return this;
    }

    @Step("ввести хобби {value}")
    public PracticeFormPage setHobbie(String value) {
        hobbiesWrapperBtn.$(byText(value)).click();
        return this;
    }

    @Step("загрузить картинку {value}")
    public PracticeFormPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    @Step("ввести текущий адрес {value}")
    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("ввести штат и город {state}, {city}")
    public PracticeFormPage setStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("нажать на кнопку сохранения")
    public PracticeFormPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    @Step("проверить результат строки и значения {tab}, {value}")
    public PracticeFormPage checkResult(String tab, String value) {
        tableResultComponent.checkResult(tab, value);
        return this;
    }
}


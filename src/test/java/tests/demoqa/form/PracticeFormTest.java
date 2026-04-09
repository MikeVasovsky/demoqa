package tests.demoqa.form;

import org.junit.jupiter.api.Test;
import tests.demoqa.TestBase;
import tests.demoqa.pages.PracticeFormPage;
import tests.demoqa.testdata.TestData;

import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData t = new TestData();

    @Test
    void correctRegistrationTest() {
        step("открыть страницу https://demoqa.com/", () ->
                practiceFormPage.openPage()
                        .removeBanner());
        step("ввести тестовые данные", () ->
                practiceFormPage.setFirstName(t.firstName)
                        .setLastName(t.lastName)
                        .setEmail(t.userEmail)
                        .setNumber(t.phoneNumber)
                        .setGender(t.gender)
                        .setDateOfBirth(t.day,
                                t.month,
                                t.year)
                        .setSubject(t.subject)
                        .setHobbie(t.hobbie)
                        .uploadPicture(t.pictureName)
                        .setCurrentAddress(t.currentAddress)
                        .setStateAndCity(t.state, t.city)
                        .clickSubmitBtn());
        step("проверить результат", () ->
                practiceFormPage.checkResult("Student Name", (t.firstName + " " + t.lastName))
                        .checkResult("Student Email", t.userEmail)
                        .checkResult("Gender", t.gender)
                        .checkResult("Mobile", t.phoneNumber)
                        .checkResult("Date of Birth", t.day + " " + t.month + "," + t.year)
                        .checkResult("Subjects", t.subject)
                        .checkResult("Hobbies", t.hobbie)
                        .checkResult("Picture", t.pictureName)
                        .checkResult("Address", t.currentAddress)
                        .checkResult("State and City", t.state + " " + t.city));
    }
}

package tests.form;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.PracticeFormPage;

import static tests.testdata.TestData.*;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void correctRegistrationTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setNumber(userNumber)
                .setGender(sex)
                .setMonth(month)
                .setYear(year)
                .setDay(day)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmitBtn()
                .checkResult(tabs,resultInTab);
    }
}

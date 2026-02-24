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
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setNumber(userNumber)
                .setGender(sex)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmitBtn()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", sex)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", resultDay + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}

package tests.jenkins;

import org.junit.jupiter.api.Test;
import tests.demoqa.pages.PracticeFormPage;
import tests.demoqa.testdata.TestData;

public class PracticeFormTestJenkins extends TestBaseJenkins {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData t = new TestData();

    @Test
    void correctRegistrationTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(t.firstName)
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
                .clickSubmitBtn()
                .checkResult("Student Name", (t.firstName + " " + t.lastName))
                .checkResult("Student Email", t.userEmail)
                .checkResult("Gender", t.gender)
                .checkResult("Mobile", t.phoneNumber)
                .checkResult("Date of Birth", t.day + " " + t.month + "," + t.year)
                .checkResult("Subjects", t.subject)
                .checkResult("Hobbies", t.hobbie)
                .checkResult("Picture", t.pictureName)
                .checkResult("Address", t.currentAddress)
                .checkResult("State and City", t.state + " " + t.city);
    }
}

package tests.form;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.PracticeFormPage;
import tests.testdata.UserTestData;

import static tests.testdata.UserFactory.createUser;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void correctRegistrationTest() {
        UserTestData u = createUser();

        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(u.getFirstName())
                .setLastName(u.getLastName())
                .setEmail(u.getEmail())
                .setNumber(u.getPhoneNumber())
                .setGender(u.getGender())
                .setDateOfBirth(u.getBirthDay(),
                        u.getBirthMonth(),
                        u.getBirthYear())
                .setSubject(u.getSubject())
                .setHobbie(u.getHobbie())
                .uploadPicture(u.getPictureName())
                .setCurrentAddress(u.getCurrentAddress())
                .setStateAndCity(u.getState(), u.getCity())
                .clickSubmitBtn()
                .checkResult("Student Name", (u.getFirstName() + " " + u.getLastName()))
                .checkResult("Student Email", u.getEmail())
                .checkResult("Gender", u.getGender())
                .checkResult("Mobile", u.getPhoneNumber())
                .checkResult("Date of Birth", u.getBirthDay() + " " + u.getBirthMonth() + "," + u.getBirthYear())
                .checkResult("Subjects", u.getSubject())
                .checkResult("Hobbies", u.getHobbie())
                .checkResult("Picture", u.getPictureName())
                .checkResult("Address", u.getCurrentAddress())
                .checkResult("State and City", u.getState() + " " + u.getCity());
    }
}

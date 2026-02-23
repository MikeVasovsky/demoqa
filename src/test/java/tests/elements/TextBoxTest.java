package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.TextBoxPage;

import static tests.testdata.TestData.*;


public class TextBoxTest extends TestBase {

    public TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successSubmitTest() {
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(username)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .checkValue("name", username)
                .checkValue("email", userEmail)
                .checkValue("currentAddress", currentAddress)
                .checkValue("permanentAddress", permanentAddress);
    }

    @Test
    void stayOnPageIfEmailIncorrectTest(){
        textBoxPage.openPage()
                .setFullName(username)
                .setEmail(badUserEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .elementShouldNotFind(expectedResultValues);
    }

}

package tests.elements;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.TextBoxPage;
import tests.testdata.TestData;

public class TextBoxTest extends TestBase {

    public TextBoxPage textBoxPage = new TextBoxPage();
    public TestData t = new TestData();
    @Test
    void successSubmitTest() {
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(t.username)
                .setEmail(t.userEmail)
                .setCurrentAddress(t.currentAddress)
                .setPermanentAddress(t.permanentAddress)
                .clickSubmit()
                .checkValue("name", t.username)
                .checkValue("email", t.userEmail)
                .checkValue("currentAddress", t.currentAddress)
                .checkValue("permanentAddress", t.permanentAddress);
    }

    @Test
    void stayOnPageIfEmailIncorrectTest() {
        textBoxPage.openPage()
                .setFullName(t.username)
                .setEmail(t.badUserEmail)
                .setCurrentAddress(t.currentAddress)
                .setPermanentAddress(t.permanentAddress)
                .clickSubmit()
                .elementShouldNotFind(t.expectedResultValues);
    }

}

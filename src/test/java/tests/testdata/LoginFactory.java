package tests.testdata;

import static tests.utils.FakerProvider.getFaker;

public class LoginFactory {

    public static LoginTestData createLoginData() {
        return new LoginTestData(
                getFaker().numerify("#"),
                getFaker().numerify("#")
        );
    }
}

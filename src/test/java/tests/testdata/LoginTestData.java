package tests.testdata;

public class LoginTestData {

    public String badLogin;
    public String badPassword;

    public LoginTestData(String badLogin, String badPassword) {
        this.badLogin = badLogin;
        this.badPassword = badPassword;
    }

    public String getBadLogin() {
        return badLogin;
    }

    public String getBadPassword() {
        return badPassword;
    }
}

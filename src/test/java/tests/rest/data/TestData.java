package tests.rest.data;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class TestData {
    public static Faker f = new Faker();

    public static final String LOGIN_USERNAME = "user8";
    public static final String LOGIN_PASSWORD = "user8";
    public static final String LOGIN_TOKEN_PREFIX = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";

    public String randomPassword = f.internet().password();
    public String randomUsername = f.name().username();
    public String randomEmail = f.internet().emailAddress();
    public String randomFirstName = f.name().firstName();
    public String randomLastName = f.name().lastName();

    public static String returnRandomUsername() {
        return f.name().username();
    }

    public static String returnRandomPassword() {
        return f.internet().password();
    }
}

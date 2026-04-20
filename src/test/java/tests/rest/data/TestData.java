package tests.rest.data;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker f = new Faker();

    public static final String LOGIN_USERNAME = "user8";
    public static final String LOGIN_PASSWORD = "user8";
    public static final String BAD_LOGIN_PASSWORD = f.internet().password();

    public static final String LOGIN_TOKEN_PREFIX = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";

}

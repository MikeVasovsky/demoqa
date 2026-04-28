package tests.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.rest.api.ApiCLient;

public class BaseTest {
    protected static final ApiCLient api = new ApiCLient();

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "https://book-club.qa.guru";
    }
}

package tests.booksclub.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.booksclub.rest.api.ApiCLient;
import tests.booksclub.rest.data.TestData;

public class BaseTest {
    protected static final ApiCLient api = new ApiCLient();

    public TestData t = new TestData();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://book-club.qa.guru";
        RestAssured.basePath = "/api/v1";
    }
}

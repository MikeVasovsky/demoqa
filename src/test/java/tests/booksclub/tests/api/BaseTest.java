package tests.booksclub.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.booksclub.rest.api.ApiClient;
import tests.booksclub.rest.data.TestData;

public class BaseTest {
    protected static final ApiClient api = new ApiClient();

    public TestData t = new TestData();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8000";
        RestAssured.basePath = "/api/v1";
    }
}

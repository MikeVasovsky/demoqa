package tests.booksclub.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.allure.ui.Attach;
import tests.booksclub.config.Remote;
import tests.booksclub.config.UiTestConfig;
import tests.booksclub.rest.api.ApiClient;
import tests.booksclub.rest.data.TestData;
import tests.booksclub.rest.models.clubs.request.createClub.CreateClubRequest;
import tests.booksclub.rest.models.clubs.response.createClub.CreateClubCorrectResponse;
import tests.booksclub.rest.models.localstorage.LocalStorageAuthModel;
import tests.booksclub.rest.models.localstorage.UserData;
import tests.booksclub.rest.models.login.request.LoginFullBodyModel;
import tests.booksclub.rest.models.login.response.SuccessfullLoginResponseModel;
import tests.booksclub.rest.models.registration.request.RegistrationFullModel;
import tests.booksclub.rest.models.registration.response.SuccessfullRegistrationResponseModel;


import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static tests.booksclub.rest.data.TestData.LOGIN_PASSWORD;
import static tests.booksclub.rest.data.TestData.returnRandomUsername;

public class BaseTest {
    ApiClient apiClient = new ApiClient();
    public TestData t = new TestData();

    RegistrationFullModel data;
    SuccessfullRegistrationResponseModel newUser;
    LoginFullBodyModel loginData;
    SuccessfullLoginResponseModel loginResponse;
    CreateClubRequest createClubData;
    CreateClubCorrectResponse newClub;


    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        UiTestConfig uiConfog = ConfigFactory.create(UiTestConfig.class, System.getProperties());
        Configuration.baseUrl = uiConfog.getUrl();
        RestAssured.baseURI = uiConfog.gerUri();
        RestAssured.basePath = uiConfog.getPath();
        Configuration.pageLoadStrategy = uiConfog.getLoadStrategy();
        Configuration.browserCapabilities = options;

        if(uiConfog.getEnv()== Remote.REMOTE){
            Configuration.remote= uiConfog.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

    }

    @BeforeEach()
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Step("Открыть станицу с новым юзером")
    public SuccessfullLoginResponseModel openPageWithNewCreateUser() {
        createUserAndLogin();
        UserData userData = new UserData(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getRemoteAddr());
        LocalStorageAuthModel authBody = new LocalStorageAuthModel(
                userData,
                loginResponse.getAccess(),
                loginResponse.getRefresh(),
                true);

        openFaviconAndSetLocalStorage("book_club_auth", authBody.toJson());

        return loginResponse;
    }

    @AfterEach
    void afterTest() {
        step("Приложить вложения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
        });
        step("Закрыть браузер", Selenide::closeWebDriver);
    }

    public void openFaviconAndSetLocalStorage(String key, String value) {
        openFavicon();
        setLocalStorage(key, value);
    }

    @Step("[API] Регистрация нового пользователя")
    public void registerUser(){
        data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        newUser = apiClient.reg.registration(data);
    }

    @Step("[API] Создание нового клуба")
    public void createNewClub(String accessLogin) {
        createClubData = t.getNewClubData();
        newClub = apiClient.clubs.createClub(createClubData, accessLogin);
    }

    @Step("[API] Создание юзера и его авторизация")
    void createUserAndLogin() {
        data = new RegistrationFullModel(returnRandomUsername(), LOGIN_PASSWORD);
        newUser = apiClient.reg.registration(data);
        loginData = new LoginFullBodyModel(newUser.getUsername(), LOGIN_PASSWORD);
        loginResponse = apiClient.auth.login(loginData);
    }

    @Step("[UI] Установка данных в localstorage")
    public void setLocalStorage(String key, String value) {
        localStorage().setItem(key, value);
    }

    @Step("[UI] Открытие /favicon.ico")
    public void openFavicon() {
        open("/favicon.ico");
    }
}


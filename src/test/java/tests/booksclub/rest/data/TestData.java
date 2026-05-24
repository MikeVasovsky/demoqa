package tests.booksclub.rest.data;

import com.github.javafaker.Faker;
import lombok.Data;
import tests.booksclub.rest.models.clubs.request.createClub.CreateClubRequest;


@Data
public class TestData {
    public static Faker f = new Faker();

    public static final String LOGIN_USERNAME = "user8";
    public static final String LOGIN_PASSWORD = "user8";
    public static final String LOGIN_TOKEN_PREFIX = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    public static final String TG_URL = "https://t.me/";

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

    public static String returnRundomTittle() {
        return f.book().title() + f.number().numberBetween(1, 1000);
    }

    public static String returnRandomAuthor() {
        return f.book().author() + f.number().numberBetween(1, 1000);
    }

    public static int returnRandomDate() {
        return f.number().numberBetween(1900, 2026);
    }

    public static String returnRandomDescription() {
        return f.weather().description();
    }

    public static String returnRandomReview() {
        return f.lorem().characters();
    }

    public static int returnRandomAssement() {
        return f.number().numberBetween(1, 5);
    }

    public static int returnRandomReadPages() {
        return f.number().numberBetween(1, 1000);
    }

    public static int returnTestClub(){
        return 4;
    }


    public CreateClubRequest getNewClubData() {
        return new CreateClubRequest(
                returnRundomTittle(),
                returnRandomAuthor(),
                returnRandomDate(),
                returnRandomDescription(),
                TG_URL);
    }

}

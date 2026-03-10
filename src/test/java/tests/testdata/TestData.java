package tests.testdata;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.Locale;

@Data
public class TestData {
    public Faker f = new Faker();
    public Faker fRu = new Faker(new Locale("ru"));

    public String firstName = f.name().firstName();
    public String lastName = f.name().lastName();
    public String userEmail = f.internet().emailAddress();
    public String badUserEmail = userEmail.replace("@", "");
    public String currentAddress = f.address().fullAddress();
    public String permanentAddress = f.address().secondaryAddress();


    public String pictureName = "sample-clouds-400x300.jpg";

    public String username = "Username!?";

    public String age = "22";
    public String salary = "20";
    public String departament = "dp";

    public static String[] expectedResultValues = {
            username,
            badUserEmail,
            currentAddress,
            permanentAddress
    };

    public static String[] expectedResultInWebTable = {
            firstName,
            lastName,
            age,
            userEmail,
            salary,
            departament
    };

    private static String[] genders = {"Male", "Female", "Other"};
    private static String[] hobbies = {"Sports", "Reading", "Music"};
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static String[] subjects = {"Arts", "Economics", "Civics"};
    private static String[] states = {"NCR", "Haryana"};
    private static String[] citysOfNcr = {"Delhi", "Gurgaon", "Noida"};
    private static String[] citysOfHaryana = {"Karnal", "Panipat"};
}




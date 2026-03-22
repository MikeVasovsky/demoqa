package tests.demoqa.testdata;

import com.github.javafaker.Faker;

public class TestData {
    public Faker f = new Faker();

    public String firstName = f.name().firstName();
    public String lastName = f.name().lastName();
    public String userEmail = f.internet().emailAddress();
    public String badUserEmail = userEmail.replace("@", "");
    public String currentAddress = f.address().fullAddress();
    public String permanentAddress = f.address().secondaryAddress();
    public String phoneNumber = f.phoneNumber().subscriberNumber(10);
    public String gender = f.options().option(genders);
    public int day = f.random().nextInt(1, 28);
    public String month = f.options().option(months);
    public String year = f.random().nextInt(1950, 2025).toString();
    public String hobbie = f.options().option(hobbies);
    public String subject = f.options().option(subjects);
    public String state = f.options().option(states);
    public String city = getRandomCity(state);

    public String pictureName = "sample-clouds-400x300.jpg";

    public String username = f.name().username();
    public String password = f.internet().password(8, 12);

    public String salary = "20";
    public String departament = "dp";

    public String[] expectedResultValues = {
            username,
            badUserEmail,
            currentAddress,
            permanentAddress
    };

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> city = f.options().option(citysOfNcr);

            case "Haryana" -> city = f.options().option(citysOfHaryana);
            default -> null;
        };
    }

    private static String[] genders = {"Male", "Female", "Other"};
    private static String[] hobbies = {"Sports", "Reading", "Music"};
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static String[] subjects = {"Arts", "Economics", "Civics"};
    private static String[] states = {"NCR", "Haryana"};
    private static String[] citysOfNcr = {"Delhi", "Gurgaon", "Noida"};
    private static String[] citysOfHaryana = {"Karnal", "Panipat"};
}




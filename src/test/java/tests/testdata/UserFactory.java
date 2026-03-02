package tests.testdata;

import static tests.testdata.TestData.pictureName;
import static tests.utils.FakerProvider.getFaker;
import static tests.utils.FakerProvider.getFakerEn;

public class UserFactory {

    private static String[] genders = {"Male", "Female", "Other"};
    private static String[] hobbies = {"Sports", "Reading", "Music"};
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static String[] subjects = {"Arts", "Economics", "Civics"};
    private static String[] states = {"NCR", "Haryana"};
    private static String[] citysOfNcr = {"Delhi", "Gurgaon", "Noida"};
    private static String[] citysOfHaryana = {"Karnal", "Panipat"};


    public static UserTestData createUser() {
        String state = getRandomState();
        String city = getRandomCity(state);

        return new UserTestData(
                getFaker().name().firstName(),
                getFaker().name().lastName(),
                getFaker().numerify("##########"),
                getFakerEn().internet().emailAddress(),
                getRandomGender(),
                getRandomDay(),
                getRandomMonth(),
                getFaker().random().nextInt(1950, 2026).toString(),
                getRandomHobbie(),
                getFaker().address().toString(),
                pictureName,
                getRandomSubject(),
                state,
                city
        );
    }

    public static String getRandomSubject() {
        return getValueFromArray(subjects);
    }

    public static String getRandomHobbie() {
        return getValueFromArray(hobbies);
    }

    public static Integer getRandomDay() {
        return getFaker().random().nextInt(1, 28);

    }

    public static String getRandomMonth() {
        return getValueFromArray(months);
    }

    public static String getRandomGender() {
        return getValueFromArray(genders);
    }

    public static String getValueFromArray(String[] array) {
        int arrayLength = array.length;
        int randomIndex = getFaker().random().nextInt(0, arrayLength - 1);
        return array[randomIndex];
    }

    public static String getRandomState() {
        return getValueFromArray(states);
    }

    public static String getRandomCity(String states) {
        return switch (states) {
            case "NCR" -> {
                int randomNcrCityIndex = getFaker().random().nextInt(0, citysOfNcr.length - 1);
                yield citysOfNcr[randomNcrCityIndex];
            }
            case "Haryana" -> {
                int randomHarayanaCityIndex = getFaker().random().nextInt(0, citysOfHaryana.length - 1);
                yield citysOfHaryana[randomHarayanaCityIndex];
            }
            default -> null;
        };
    }


}

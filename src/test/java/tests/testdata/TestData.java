package tests.testdata;

public class TestData {
    public static String firstName = "ivan?";
    public static String lastName = "ivanov?";
    public static String userEmail = "simpleEmail@gmail.com";
    public static String badUserEmail = "!!!!2@sds";
    public static String currentAddress = "my_address";
    public static String permanentAddress = "permanent_address";


    public static String pictureName = "sample-clouds-400x300.jpg";

    public static String username = "Username!?";

    public static String age = "22";
    public static String salary = "20";
    public static String departament = "dp";

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
}




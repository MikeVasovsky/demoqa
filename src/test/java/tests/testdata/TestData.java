package tests.testdata;

public class TestData {
    public static String firstName = "ivan?";
    public static String lastName = "ivanov?";
    public static String userEmail = "simpleEmail@gmail.com";
    public static String badUserEmail = "!!!!2@sds";
    public static String userNumber = "8800888776";
    public static String currentAddress = "my_address";
    public static String permanentAddress = "permanent_address";

    public static String hobbies = "Sports";
    public static String subject = "arts";
    public static String sex = "Male";

    public static String day = "010";
    public static String month = "May";
    public static String year = "1990";
    public static String resultDay = day.substring(1);

    public static String state = "NCR";
    public static String city = "Delhi";

    public static String pictureName = "sample-clouds-400x300.jpg";

    public static String username = "Username!?";

    public static String badLogin = "2";
    public static String badPassword = "2";

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




package tests.testdata;

public class UserTestData {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Integer birthDay;
    private String birthMonth;
    private String birthYear;
    private String hobbie;
    private String currentAddress;
    private String pictureName;
    private String subject;
    private String state;
    private String city;


    public UserTestData(String firstName,
                        String lastName,
                        String phoneNumber,
                        String email,
                        String gender,
                        Integer birthDay,
                        String birthMonth,
                        String birthYear,
                        String hobbie,
                        String currentAddress,
                        String pictureName,
                        String subject,
                        String state,
                        String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.hobbie = hobbie;
        this.currentAddress = currentAddress;
        this.pictureName = pictureName;
        this.subject = subject;
        this.state = state;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getHobbie() {
        return hobbie;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getSubject() {
        return subject;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}

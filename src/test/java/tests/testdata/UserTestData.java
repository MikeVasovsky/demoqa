package tests.testdata;

import lombok.Data;

@Data
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

}

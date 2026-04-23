package tests.rest.models.registration.response;

import lombok.Data;

@Data
public class SuccessfullRegistrationResponseModel {
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String remoteAddr;
}

package tests.rest.models.put.response;

import lombok.Data;

@Data
public class CorrectPutResponseModel {
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String remoteAddr;
}

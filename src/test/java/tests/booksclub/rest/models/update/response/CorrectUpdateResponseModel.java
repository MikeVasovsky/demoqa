package tests.booksclub.rest.models.update.response;

import lombok.Data;

@Data
public class CorrectUpdateResponseModel {
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String remoteAddr;
}

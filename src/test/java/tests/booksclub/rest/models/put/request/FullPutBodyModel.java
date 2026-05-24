package tests.booksclub.rest.models.put.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FullPutBodyModel {
    String username;
    String firstName;
    String lastName;
    String password;
    String email;
}

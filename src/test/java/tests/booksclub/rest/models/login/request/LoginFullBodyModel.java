package tests.booksclub.rest.models.login.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginFullBodyModel {
     String username;
     String password;
}

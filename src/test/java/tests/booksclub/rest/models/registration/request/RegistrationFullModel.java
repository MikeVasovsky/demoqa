package tests.booksclub.rest.models.registration.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationFullModel {
    String username;
    String password;
}

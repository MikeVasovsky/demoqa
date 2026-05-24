package tests.booksclub.rest.models.registration.response;

import lombok.Data;

@Data
public class RegistrationWithoutPasswordAndRepeateUsername {
    String[] username;
    String[] password;
}

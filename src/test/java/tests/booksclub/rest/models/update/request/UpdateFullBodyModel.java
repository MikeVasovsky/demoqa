package tests.booksclub.rest.models.update.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateFullBodyModel {
    String username;
    String firstName;
    String lastName;
    String email;
}

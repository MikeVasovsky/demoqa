package tests.rest.models.update.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateFullBodyModel {
    String username;
    String firstname;
    String lastname;
    String email;
}

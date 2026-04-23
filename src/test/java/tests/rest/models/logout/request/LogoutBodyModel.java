package tests.rest.models.logout.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogoutBodyModel {
    String refresh;
}

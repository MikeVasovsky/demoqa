package tests.rest.models.login;

import lombok.Data;

@Data
public class SuccessfulLoginResponseModel {
    String access;
    String refresh;
}

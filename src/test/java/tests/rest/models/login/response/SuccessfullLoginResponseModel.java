package tests.rest.models.login.response;

import lombok.Data;

@Data
public class SuccessfullLoginResponseModel {
    String access;
    String refresh;
}

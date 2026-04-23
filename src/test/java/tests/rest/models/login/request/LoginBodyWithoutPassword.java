package tests.rest.models.login.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginBodyWithoutPassword {
    String username;
}

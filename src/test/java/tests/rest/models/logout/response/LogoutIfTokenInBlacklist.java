package tests.rest.models.logout.response;

import lombok.Data;

@Data
public class LogoutIfTokenInBlacklist {
    String detail;
    String code;
}

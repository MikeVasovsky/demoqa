package tests.booksclub.rest.models.localstorage;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public record LocalStorageAuthModel(UserData user,
                                    String accessToken,
                                    String refreshToken,
                                    boolean isAuthenticated) {
    private static final JsonMapper JSON = JsonMapper.builder().build();

    public String toJson() {
        try {
            return JSON.writeValueAsString(this);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}

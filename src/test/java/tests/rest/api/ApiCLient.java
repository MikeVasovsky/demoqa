package tests.rest.api;

import tests.rest.api.clubs.ClubClient;

public class ApiCLient {

    public final AuthApiClient auth = new AuthApiClient();
    public final RegistrationApiClient reg = new RegistrationApiClient();
    public final LogoutApiClient log = new LogoutApiClient();
    public final UpdateApi updt = new UpdateApi();
    public final PutApi put = new PutApi();
    public final ClubClient clubs = new ClubClient();
}

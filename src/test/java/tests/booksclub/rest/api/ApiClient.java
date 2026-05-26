package tests.booksclub.rest.api;

public class ApiClient {

    public final AuthApiClient auth = new AuthApiClient();
    public final RegistrationApiClient reg = new RegistrationApiClient();
    public final LogoutApiClient log = new LogoutApiClient();
    public final UpdateApi updt = new UpdateApi();
    public final PutApi put = new PutApi();
    public final ClubClient clubs = new ClubClient();
    public final ReviewsClient reviews = new ReviewsClient();
    public final MembersClient  members = new MembersClient();
}

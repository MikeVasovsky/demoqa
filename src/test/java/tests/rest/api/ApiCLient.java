package tests.rest.api;

import tests.rest.api.clubs.ClubClient;
import tests.rest.api.members.MembersClient;
import tests.rest.api.reviews.ReviewsClient;

public class ApiCLient {

    public final AuthApiClient auth = new AuthApiClient();
    public final RegistrationApiClient reg = new RegistrationApiClient();
    public final LogoutApiClient log = new LogoutApiClient();
    public final UpdateApi updt = new UpdateApi();
    public final PutApi put = new PutApi();
    public final ClubClient clubs = new ClubClient();
    public final ReviewsClient reviews = new ReviewsClient();
    public final MembersClient  members = new MembersClient();
}

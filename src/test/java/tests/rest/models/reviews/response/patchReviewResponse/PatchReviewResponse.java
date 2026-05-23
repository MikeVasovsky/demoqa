package tests.rest.models.reviews.response.patchReviewResponse;

import lombok.Data;
import tests.rest.models.clubs.response.getById.User;

@Data
public class PatchReviewResponse {
    int id;
    int club;
    User user;
    String review;
    int assessment;
    int readPages;
    String created;
    String modified;
}

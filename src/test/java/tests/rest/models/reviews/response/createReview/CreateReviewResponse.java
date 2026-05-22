package tests.rest.models.reviews.response.createReview;

import lombok.Data;
import tests.rest.models.clubs.response.getById.User;

@Data
public class CreateReviewResponse {
    int id;
    int club;
    User user;
    String review;
    int assessment;
    int readPages;
    String created;
    String modified;
}

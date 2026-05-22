package tests.rest.models.reviews.request.createReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest {
    int assessment;
    int club;
    int readPages;
    String review;

}

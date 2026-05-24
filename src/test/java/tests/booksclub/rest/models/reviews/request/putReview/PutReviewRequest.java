package tests.booksclub.rest.models.reviews.request.putReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutReviewRequest {
    int assessment;
    int club;
    int readPages;
    String review;
}

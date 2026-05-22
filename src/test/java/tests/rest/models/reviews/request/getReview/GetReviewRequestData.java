package tests.rest.models.reviews.request.getReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReviewRequestData {
    int club;
    int page;
    int pageSize;
}

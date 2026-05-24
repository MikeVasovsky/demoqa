package tests.booksclub.rest.models.reviews.request.patchReviewRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchReviewRequest {
    int assessment;
    int club;
    int readPages;
    String review;
}

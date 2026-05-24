package tests.booksclub.rest.models.reviews.response.getReview;

import lombok.Data;

import java.util.List;

@Data
public class GetReviewResponse {
    private String next;
    private Object previous;
    private int count;
    private List<ResultsItem> results;
}
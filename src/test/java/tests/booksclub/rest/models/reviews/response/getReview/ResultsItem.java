package tests.booksclub.rest.models.reviews.response.getReview;

import lombok.Data;

@Data
public class ResultsItem{
    private int assessment;
    private String review;
    private String created;
    private int club;
    private int readPages;
    private Object modified;
    private int id;
    private User user;
}

package tests.rest.models.clubs.response.createClub;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsItem{
    private int assessment;
    private String review;
    private String created;
    private int club;
    private int readPages;
    private String modified;
    private int id;
    private User user;
}

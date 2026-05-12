package tests.rest.models.clubs.response.getById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClubByIdCorrectResponse{
    private int owner;
    private String bookAuthors;
    private List<ReviewsItem> reviews;
    private String created;
    private List<Integer> members;
    private int publicationYear;
    private String description;
    private String modified;
    private int id;
    private String telegramChatLink;
    private String bookTitle;
}
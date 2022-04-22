package site.metacoding.everytimeclone.web.api.dto.scrap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.scrap.Scrap;
import site.metacoding.everytimeclone.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScrapReqDto {

    private Post postId;
    private User userId;

    public Scrap toEntity(Post post, User principal) {
        Scrap scrap = new Scrap();

        scrap.setPost(post);
        scrap.setUser(principal);

        return scrap;
    }
}

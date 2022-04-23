package site.metacoding.everytimeclone.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WriteReqDto {
    private String title;
    private String content;
    private String thumnail;
    private Integer boardNo;
    private Integer likeCount;
    private boolean anonyCheck;
    private String hashTag;

    public Post toEntity(User principal) {
        Post post = new Post();

        post.setTitle(title);
        post.setContent(content);
        post.setThumnail(thumnail);
        post.setUser(principal);
        post.setBoardNo(boardNo);
        post.setLikeCount(0);
        post.setScrapCount(0);
        post.setAnonyCheck(anonyCheck);
        post.setHashTag(hashTag);

        return post;
    }
}

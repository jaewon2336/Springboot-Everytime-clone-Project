package site.metacoding.everytimeclone.web.api.dto.post;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardResDto {

    private Integer boardNo;
    private Page<Post> posts;
    private Integer prev;
    private Integer next;
}

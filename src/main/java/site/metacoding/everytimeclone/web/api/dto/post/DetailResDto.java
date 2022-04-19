package site.metacoding.everytimeclone.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailResDto {
    private Post post;
    private boolean auth;
}

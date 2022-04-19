package site.metacoding.everytimeclone.web.api.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.comment.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResDto {
    private Comment comment;
    private boolean auth;
}
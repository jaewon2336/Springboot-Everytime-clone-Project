package site.metacoding.everytimeclone.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.CommentService;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;
    private final HttpSession session;

    @GetMapping("/api/post/{id}/comment")
    public ResponseEntity<?> getCommentCount(@PathVariable Integer id) {
        // id로 post 찾아서 comment 카운팅 해오기
        Integer commentCount = commentService.댓글수가져오기(id);

        return new ResponseEntity<>(commentCount, HttpStatus.OK);
    }

    @DeleteMapping("/s/api/comment/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {

        // 권한처리
        // 세션의 id와 comment의 userId와 비교
        User principal = (User) session.getAttribute("principal");

        commentService.댓글삭제(id, principal);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}

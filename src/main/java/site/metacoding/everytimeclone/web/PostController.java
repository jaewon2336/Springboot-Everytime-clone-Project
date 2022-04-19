package site.metacoding.everytimeclone.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.comment.Comment;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostController {

    // private final PostService postService;
    private final HttpSession session;

    // 메인
    @GetMapping("/")
    public String main() {
        return "/post/main";
    }

    @GetMapping("/s/board")
    public String free() {
        return "/board/freeBoard";
    }

    // 글 상세보기
    // @GetMapping("/post/{id}")
    // public String detail(@PathVariable Integer id, Model model) {

    // Post postEntity = postService.글상세보기(id);

    // // comment의 userId랑 세션에 id랑 비교
    // User principal = (User) session.getAttribute("principal");

    // // 댓글 뿌리기
    // List<CommentResponseDto> comments = new ArrayList<>();

    // for (Comment comment : postEntity.getComments()) {
    // CommentResponseDto dto = new CommentResponseDto();
    // if (comment.isAnonyCheck() == true) {
    // comment.getUser().setUsername("익명");
    // }

    // dto.setComment(comment);
    // if (principal != null) { // 인증
    // if (principal.getId() == comment.getUser().getId()) { // 권한
    // dto.setAuth(true);
    // } else {
    // dto.setAuth(false);
    // }
    // }
    // comments.add(dto);
    // }

    // model.addAttribute("commentCount", comments.size()); // 댓글 개수 모델에 담아가기
    // model.addAttribute("likeCount", postEntity.getLikeCount());
    // model.addAttribute("comments", comments);
    // model.addAttribute("postId", id);

    // return "post/detail";
    // }

}

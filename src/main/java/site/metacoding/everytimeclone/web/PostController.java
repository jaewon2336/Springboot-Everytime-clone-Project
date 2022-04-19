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
import site.metacoding.everytimeclone.web.api.dto.comment.CommentResDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    // 메인
    @GetMapping("/")
    public String main() {
        return "/post/main";
    }

    @GetMapping("/s/board/{boardNo}")
    public String board(@PathVariable Integer boardNo) {
        switch (boardNo) {
            case 1:
                return "/board/freeBoard";
            case 2:
                return "/board/secretBoard";
            case 3:
                return "/board/graduateBoard";
            case 4:
                return "/board/freshmanBoard";
            case 5:
                return "/board/previewBoard";
            case 6:
                return "/board/marketBoard";
            case 7:
                return "/board/promotionBoard";
            case 8:
                return "/board/clubBoard";
            case 9:
                return "/board/employBoard";
        }

        return "redirect:/";
    }

    // 글 상세보기
    @GetMapping("/s/post/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        Post postEntity = postService.글상세보기(id);

        // comment의 userId랑 세션에 id랑 비교
        User principal = (User) session.getAttribute("principal");

        // 댓글 뿌리기
        List<CommentResDto> comments = new ArrayList<>();

        for (Comment comment : postEntity.getComments()) {
            CommentResDto dto = new CommentResDto();
            if (comment.isAnonyCheck() == true) {
                comment.getUser().setUsername("익명");
            }

            dto.setComment(comment);
            if (principal != null) { // 인증
                if (principal.getId() == comment.getUser().getId()) { // 권한
                    dto.setAuth(true);
                } else {
                    dto.setAuth(false);
                }
            }
            comments.add(dto);
        }

        model.addAttribute("commentCount", comments.size()); // 댓글 개수 모델에 담아가기
        model.addAttribute("comments", comments);
        model.addAttribute("postEntity", postEntity);

        return "post/detail";
    }

    // 글 수정폼
    @GetMapping("/s/post/{id}/update")
    public String updateForm(@PathVariable Integer id, Model model) {
        User principal = (User) session.getAttribute("principal");

        Post postEntity = postService.글상세보기(id);

        if (postEntity.getUser().getId() != principal.getId()) {
            throw new RuntimeException("수정할 권한이 없습니다.");
        }

        model.addAttribute("post", postEntity);

        return "post/updateForm";
    }

}

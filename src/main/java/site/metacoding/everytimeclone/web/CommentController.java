package site.metacoding.everytimeclone.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.comment.Comment;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.CommentService;
import site.metacoding.everytimeclone.service.PostService;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;
    private final HttpSession session;

    // 댓글 쓰기
    @PostMapping("/s/post/{postId}/comment")
    public String write(@PathVariable Integer postId, Comment comment) {

        User principal = (User) session.getAttribute("principal");

        comment.setUser(principal);

        commentService.댓글쓰기(comment, postId);
        return "redirect:/s/post/" + postId;
    }

    // 내가 쓴 댓글 목록
    @GetMapping("/s/user/{id}/comment")
    public String myCommentList(@PathVariable Integer id, Model model) {
        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        // SELECT * FROM comment WHERE userId = :id
        List<Comment> comments = commentService.댓글가져오기(id);
        model.addAttribute("comments", comments);

        return "/user/myCommentList";
    }
}

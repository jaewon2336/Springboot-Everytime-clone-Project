package site.metacoding.everytimeclone.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import site.metacoding.everytimeclone.web.api.dto.post.BoardResDto;
import site.metacoding.everytimeclone.web.api.dto.post.DetailResDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    // 메인
    @GetMapping("/")
    public String main(Model model) {

        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        // post findAll해서 가져오기
        List<Post> postsBy1 = postService.게시글미리보기(1);
        List<Post> postsBy2 = postService.게시글미리보기(2);
        List<Post> postsBy3 = postService.게시글미리보기(3);
        List<Post> postsBy4 = postService.게시글미리보기(4);
        List<Post> postsBy5 = postService.게시글미리보기(5);
        List<Post> postsBy6 = postService.게시글미리보기(6);
        List<Post> postsBy7 = postService.게시글미리보기(7);
        List<Post> postsBy8 = postService.게시글미리보기(8);
        List<Post> postsBy9 = postService.게시글미리보기(9);

        model.addAttribute("postsBy1", postsBy1);
        model.addAttribute("postsBy2", postsBy2);
        model.addAttribute("postsBy3", postsBy3);
        model.addAttribute("postsBy4", postsBy4);
        model.addAttribute("postsBy5", postsBy5);
        model.addAttribute("postsBy6", postsBy6);
        model.addAttribute("postsBy7", postsBy7);
        model.addAttribute("postsBy8", postsBy8);
        model.addAttribute("postsBy9", postsBy9);

        return "/post/main";
    }

    // 게시판 이동(글 목록)
    @GetMapping("/s/board/{boardNo}")
    public String board(@PathVariable Integer boardNo, Model model, @PageableDefault(size = 5) Pageable pageable) {

        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        // SELECT * FROM post WHERE userId = :id AND boardNo = :boardNo
        BoardResDto boardResDto = postService.카테고리별게시글목록보기(boardNo, pageable);

        model.addAttribute("boardResDto", boardResDto);

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

        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        Post postEntity = postService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");
        boolean auth = false;

        // 권한체크
        if (principal.getId() == postEntity.getUser().getId()) {
            if (principal.getId() == postEntity.getUser().getId()) {
                auth = true;
            }

            if (postEntity.isAnonyCheck() == true) {
                postEntity.getUser().setUsername("익명");
            }
        }

        DetailResDto detailResDto = new DetailResDto(postEntity, auth);

        // 댓글 뿌리기
        List<CommentResDto> comments = new ArrayList<>();

        for (Comment comment : postEntity.getComments()) {
            CommentResDto dto = new CommentResDto();
            dto.setComment(comment);

            // comment의 userId랑 세션에 id랑 비교
            if (principal != null) { // 인증
                if (principal.getId() == comment.getUser().getId()) { // 권한
                    dto.setAuth(true);
                } else {
                    dto.setAuth(false);
                }
            }

            comments.add(dto);
        }

        model.addAttribute("comments", comments);
        model.addAttribute("detailResDto", detailResDto);

        return "post/detail";
    }

    // 글 수정폼
    @GetMapping("/s/post/{id}/update-form")
    public String updateForm(@PathVariable Integer id, Model model) {

        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        User principal = (User) session.getAttribute("principal");

        Post postEntity = postService.글상세보기(id);

        if (postEntity.getUser().getId() != principal.getId()) {
            throw new RuntimeException("수정할 권한이 없습니다.");
        }

        model.addAttribute("post", postEntity);

        return "post/updateForm";
    }

    // 문의하기 게시판 이동

    @GetMapping("/qna/main")
    public String qnaForm() {
        return "/qna/qnaForm";
    }

    @GetMapping("/qna/community-rule")
    public String community() {
        return "/qna/communityRule";
    }

    @GetMapping("/qna/account")
    public String qnaAccount() {
        return "/qna/qnaAccount";
    }

    @GetMapping("/qna/school")
    public String qnaSchool() {
        return "/qna/qnaSchool";
    }

    @GetMapping("/qna/timetable")
    public String qnaTimetable() {
        return "/qna/qnaTimetable";
    }

    @GetMapping("/qna/community")
    public String qnaCommunity() {
        return "/qna/qnaCommunity";
    }

    @GetMapping("/qna/anony")
    public String qnaAnony() {
        return "/qna/qnaAnony";
    }

    @GetMapping("/qna/report")
    public String qnaReport() {
        return "/qna/qnaReport";
    }

    @GetMapping("/qna/other")
    public String qndOther() {
        return "/qna/qnaOther";
    }

    @GetMapping("/policy")
    public String policy() {
        return "/qna/policy";
    }

    @GetMapping("/usageContract")
    public String usageContract() {
        return "/qna/usageContract";
    }

}

package site.metacoding.everytimeclone.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.PostService;
import site.metacoding.everytimeclone.web.api.dto.post.WriteReqDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final HttpSession session;

    // 글쓰기
    @PostMapping("/s/post")
    public ResponseEntity<?> write(@RequestBody WriteReqDto writeReqDto) {
        User principal = (User) session.getAttribute("principal");
        Post post = writeReqDto.toEntity(principal);
        postService.글쓰기(post);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    // 글목록
    @GetMapping("/s/api/post/list")
    public ResponseEntity<?> list(String keyword, Integer page, Integer boardNo,
            @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Post> posts = postService.글목록보기(keyword, pageable, boardNo);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}

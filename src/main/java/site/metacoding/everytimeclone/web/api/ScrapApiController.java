package site.metacoding.everytimeclone.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.scrap.Scrap;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.PostService;
import site.metacoding.everytimeclone.service.ScrapService;
import site.metacoding.everytimeclone.web.api.dto.scrap.ScrapReqDto;
import site.metacoding.everytimeclone.web.api.dto.scrap.ScrapRespDto;

@RequiredArgsConstructor
@RestController
public class ScrapApiController {

    private final ScrapService scrapService;
    private final PostService postService;
    private final HttpSession session;

    // 스크랩하기
    @PostMapping("/s/api/post/{postId}/scrap")
    public ResponseEntity<?> scrap(@PathVariable Integer postId, ScrapReqDto scrapReqDto) {
        // 1. 스크랩버튼을 누른다
        // 2. DB의 scrap 테이블에 저장된다 (누가 몇 번 글을 스크랩했나)

        User principal = (User) session.getAttribute("principal");

        scrapService.스크랩하기(scrapReqDto, postId, principal);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    // 스크랩카운팅
    @PutMapping("/s/api/post/{postId}/scrap")
    public ResponseEntity<?> scrapUp(@PathVariable Integer postId) {
        Post postEntity = scrapService.스크랩카운팅(postService.글상세보기(postId));
        return new ResponseEntity<>(postEntity, HttpStatus.OK);
    }

}

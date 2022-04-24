package site.metacoding.everytimeclone.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.scrap.Scrap;
import site.metacoding.everytimeclone.service.PostService;
import site.metacoding.everytimeclone.service.ScrapService;

@RequiredArgsConstructor
@Controller
public class ScrapController {

    private final ScrapService scrapService;
    private final PostService postService;

    @GetMapping("/s/user/{id}/scrap")
    public String myScrapList(@PathVariable Integer id, Model model) {

        List<Post> orderByLikeCountPosts = postService.실시간인기글();
        model.addAttribute("hotPosts", orderByLikeCountPosts);

        List<Scrap> scraps = scrapService.스크랩목록보기(id);
        model.addAttribute("scraps", scraps);

        return "/user/myScrapList";
    }
}

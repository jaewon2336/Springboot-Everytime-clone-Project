package site.metacoding.everytimeclone.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.scrap.Scrap;
import site.metacoding.everytimeclone.service.ScrapService;

@RequiredArgsConstructor
@Controller
public class ScrapController {

    private final ScrapService scrapService;

    @GetMapping("/s/{userId}/my-scrap")
    public String scrapList(@PathVariable Integer userId, Model model) {

        List<Scrap> scrapRespDto = scrapService.스크랩목록보기(userId);
        // System.out.println(scrapRespDto.get(0));
        model.addAttribute("scrapRespDto", scrapRespDto);

        return "/user/myScrapList";
    }
}

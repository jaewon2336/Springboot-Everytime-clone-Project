package site.metacoding.everytimeclone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {

    // 메인
    @GetMapping("/")
    public String main() {
        return "/post/main";
    }

}

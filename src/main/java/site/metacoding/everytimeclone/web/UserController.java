package site.metacoding.everytimeclone.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.UserService;
import site.metacoding.everytimeclone.util.UtilValid;
import site.metacoding.everytimeclone.util.email.EmailUtil;
import site.metacoding.everytimeclone.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/user/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/user/join-form")
    public String joinForm(JoinDto joinDto) {
        return "/user/joinForm";
    }

    @PostMapping("/join")
    public String join(@Valid JoinDto joinDto, BindingResult bindingResult) {
        // 핵심로직
        UtilValid.요청에러처리(bindingResult);
        userService.회원가입(joinDto.toEntity());
        return "redirect:/user/loginForm";
    }

    @GetMapping("/user/find-username-form")
    public String findUsernameForm() {
        return "/user/findUsernameForm";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {
        return "/user/passwordResetForm";
    }
}
package site.metacoding.everytimeclone.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.UserService;
import site.metacoding.everytimeclone.util.Script;
import site.metacoding.everytimeclone.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/api/user/username-same-check")
    public ResponseEntity<?> usernameSameCheck(String username) {
        boolean isNotSame = userService.유저네임중복검사(username);
        return new ResponseEntity<>(isNotSame, HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto, BindingResult bindingResult,
            HttpServletResponse response) {
        // 인증
        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }

        session.setAttribute("principal", userEntity); // 세션에 저장

        // System.out.println(loginDto.getRemember()); // on

        // 쿠키에 저장
        if (loginDto.getRemember().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";path=/");
        }

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return Script.href("/", "로그아웃 되었습니다.");
    }

}

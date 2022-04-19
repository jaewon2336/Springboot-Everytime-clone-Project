package site.metacoding.everytimeclone.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.UserService;
import site.metacoding.everytimeclone.util.Script;
import site.metacoding.everytimeclone.util.UtilValid;
import site.metacoding.everytimeclone.util.email.EmailUtil;
import site.metacoding.everytimeclone.web.api.dto.user.EmailUpdateDto;
import site.metacoding.everytimeclone.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;
    private final EmailUtil emailUtil;

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

    @GetMapping("/user/find-username")
    public String findUsername(String email) {

        User userEntity = userService.유저네임보내주기(email);

        emailUtil.sendEmail(userEntity.getEmail(), "요청하신 이메일의 ID",
                "ID : " + userEntity.getUsername());

        return Script.href("/user/login-form", "안내 이메일을 발송하였습니다. 만약 메일이 오지 않는다면, 스팸 편지함을 확인해주세요.");
    }

    @PutMapping("/user/password-reset")
    public ResponseEntity<?> passwordReset(@RequestBody User user) {

        System.out.println(user);

        User userEntity = userService.패스워드초기화(user.getUsername(), user.getEmail());

        emailUtil.sendEmail(userEntity.getEmail(), "비밀번호가 초기화 되었습니다",
                "초기화된 비밀번호는 " + userEntity.getPassword() + " 입니다. 로그인 후 비밀번호를 재설정하십시오.");

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @PutMapping("/s/api/user/{id}/email")
    public ResponseEntity<?> updateEmail(@PathVariable Integer id, @Valid @RequestBody EmailUpdateDto emailUpdateDto,
            BindingResult bindingResult) {
        UtilValid.요청에러처리(bindingResult);

        userService.이메일수정(id, emailUpdateDto);

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}

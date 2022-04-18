package site.metacoding.everytimeclone.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.domain.user.UserRepository;
import site.metacoding.everytimeclone.handler.ex.CustomException;
import site.metacoding.everytimeclone.util.email.EmailUtil;
import site.metacoding.everytimeclone.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public boolean 유저네임중복검사(String username) {
        Optional<User> userOp = userRepository.findByUsername(username);

        if (userOp.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    public void 회원가입(User user) {
        userRepository.save(user);
    }

    public User 로그인(LoginDto loginDto) {
        return userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
    }

    public User 유저네임보내주기(String email) {

        Optional<User> userOp = userRepository.findByEmail(email);

        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new CustomException("해당 이메일이 존재하지 않습니다");
        }
    }
}
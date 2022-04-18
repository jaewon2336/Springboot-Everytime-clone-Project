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

    @Transactional
    public User 패스워드초기화(String username, String email) {
        Optional<User> userOp = userRepository.findByUsernameAndEmail(username, email);

        if (userOp.isPresent()) {
            User userEntity = userOp.get();

            // 6자의 난수 생성 후 비밀번호 지정
            Integer randomNum = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
            String randomPassword = randomNum.toString();

            userEntity.setPassword(randomPassword);
            return userEntity;
        } else {
            throw new CustomException("해당 아이디가 존재하지 않습니다");
        }
    }
}
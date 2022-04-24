package site.metacoding.everytimeclone.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.service.CertificateService;
import site.metacoding.everytimeclone.web.api.dto.certificate.CertificateRegisterDto;

@RequiredArgsConstructor
@Controller
public class CertificateController {

    private final CertificateService certificateService;
    private final HttpSession session;

    @GetMapping("/s/user/certificate-registration")
    public String certificateForm() {
        return "/certificate/certificateForm";
    }

    @PostMapping("/s/qna/qna-school-register")
    public String register(CertificateRegisterDto certificateRegisterDto) {

        User principal = (User) session.getAttribute("principal");

        certificateService.증명서제출하기(certificateRegisterDto, principal);
        return "/user/detail";
    }
}

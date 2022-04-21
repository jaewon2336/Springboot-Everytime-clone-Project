package site.metacoding.everytimeclone.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.certificate.Certificate;
import site.metacoding.everytimeclone.domain.certificate.CertificateRepository;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.util.UtilFileUpload;
import site.metacoding.everytimeclone.web.api.dto.certificate.CertificateRegisterDto;

@RequiredArgsConstructor
@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void 증명서제출하기(CertificateRegisterDto certificateRegisterDto, User principal) {

        String imgUrl = UtilFileUpload.write(uploadFolder, certificateRegisterDto.getCertificate());
        Certificate certificateUrl = certificateRegisterDto.toEntity(imgUrl, principal);

        certificateRepository.save(certificateUrl);
    }

}

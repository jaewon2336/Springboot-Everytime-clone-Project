package site.metacoding.everytimeclone.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.post.PostRepository;
import site.metacoding.everytimeclone.domain.scrap.Scrap;
import site.metacoding.everytimeclone.domain.scrap.ScrapRepository;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.web.api.dto.scrap.ScrapReqDto;

@RequiredArgsConstructor
@Service
public class ScrapService {

    private final ScrapRepository scrapRepository;
    private final PostRepository postRepository;

    public void 스크랩하기(ScrapReqDto scrapReqDto, Integer postId, User principal) {
        Optional<Post> postOp = postRepository.findById(postId);

        if (postOp.isPresent()) {

            Post postEntity = postOp.get();
            Scrap scrap = scrapReqDto.toEntity(postEntity, principal);
            scrapRepository.save(scrap);

        } else {
            throw new RuntimeException("이미 삭제된 포스트입니다.");
        }
    }
}

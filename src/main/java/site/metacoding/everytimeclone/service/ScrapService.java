package site.metacoding.everytimeclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
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

    @Transactional
    public Post 스크랩카운팅(Post post) {
        Optional<Post> postOp = postRepository.findById(post.getId());

        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            postEntity.setScrapCount(post.getScrapCount() + 1);
            return postEntity;
        } else {
            throw new RuntimeException("이미 스크랩한 글입니다");
        }
    }

    public List<Scrap> 스크랩목록보기(Integer userId) {

        List<Scrap> scrapsEntity = scrapRepository.findByUserId(userId);

        // ScrapRespDto scrapRespDto = new ScrapRespDto(scrapsEntity);

        return scrapsEntity;
    }
}

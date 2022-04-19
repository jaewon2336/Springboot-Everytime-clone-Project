package site.metacoding.everytimeclone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.post.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }

    public Page<Post> 글목록보기(String keyword, Pageable pageable, Integer boardNo) {
        return postRepository.findByTitleContaining(keyword, pageable, boardNo);
    }

}

package site.metacoding.everytimeclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.comment.Comment;
import site.metacoding.everytimeclone.domain.comment.CommentRepository;
import site.metacoding.everytimeclone.domain.post.Post;
import site.metacoding.everytimeclone.domain.post.PostRepository;
import site.metacoding.everytimeclone.domain.user.User;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<Comment> 댓글가져오기(Integer id) {
        return commentRepository.findByUserId(id);
    }

    public Integer 댓글수가져오기(Integer id) {
        return commentRepository.countComments(id);
    }

    @Transactional
    public void 댓글쓰기(Comment comment, Integer postId) {
        Optional<Post> postOp = postRepository.findById(postId);

        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            comment.setPost(postEntity);

            Integer commentCount = postEntity.getComments().size();
            postEntity.setCommentCount(commentCount + 1);
        } else {
            throw new RuntimeException("없는 게시글에 댓글을 작성할 수 없습니다.");
        }
        commentRepository.save(comment);
    }

    @Transactional
    public void 댓글삭제(Integer id, User principal) {

        Optional<Comment> commentOp = commentRepository.findById(id);
        if (commentOp.isPresent()) {
            Comment commentEntity = commentOp.get();

            if (principal.getId() != commentEntity.getUser().getId()) {
                throw new RuntimeException("권한이 없습니다.");
            }

        } else {
            throw new RuntimeException("해당 댓글이 없습니다.");
        }

        commentRepository.deleteById(id);
    }
}

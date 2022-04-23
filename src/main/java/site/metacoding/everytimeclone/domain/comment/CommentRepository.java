package site.metacoding.everytimeclone.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT COUNT(*) FROM comment WHERE postId = :id", nativeQuery = true)
    Integer countComments(@Param("id") Integer id);

}

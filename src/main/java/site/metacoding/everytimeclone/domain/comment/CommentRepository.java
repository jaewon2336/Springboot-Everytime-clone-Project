package site.metacoding.everytimeclone.domain.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT COUNT(*) FROM comment WHERE postId = :id", nativeQuery = true)
    Integer countComments(@Param("id") Integer id);

    @Query(value = "SELECT * FROM comment WHERE userId = :id", nativeQuery = true)
    List<Comment> findByUserId(@Param("id") Integer id);

}

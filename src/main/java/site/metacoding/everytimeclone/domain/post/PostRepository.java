package site.metacoding.everytimeclone.domain.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM post p WHERE boardNo = :boardNo ORDER BY p.id DESC", nativeQuery = true)
    Page<Post> findByBoardNo(@Param("boardNo") Integer boardNo, Pageable pageable);

    @Query(value = "SELECT * FROM post WHERE boardno = :boardNo ORDER BY id DESC LIMIT 2", nativeQuery = true)
    List<Post> mfindByBoardNoLimit(@Param("boardNo") Integer boardNo);

    @Query(value = "SELECT * FROM post WHERE userId = :userId ORDER BY id DESC", nativeQuery = true)
    List<Post> findByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM post ORDER BY likeCount DESC LIMIT 2", nativeQuery = true)
    List<Post> findByLikeCount();
}
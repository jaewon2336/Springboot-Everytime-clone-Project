package site.metacoding.everytimeclone.domain.scrap;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScrapRepository extends JpaRepository<Scrap, Integer> {

    @Query(value = "SELECT * FROM scrap WHERE userId = :userId ORDER BY id DESC", nativeQuery = true)
    List<Scrap> findByUserId(@Param("userId") Integer userId);
}

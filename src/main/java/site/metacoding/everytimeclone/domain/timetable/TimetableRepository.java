package site.metacoding.everytimeclone.domain.timetable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    @Query(value = "SELECT * FROM timetable WHERE userId = :userId", nativeQuery = true)
    List<Timetable> findByUserId(@Param("userId") Integer userId);

}

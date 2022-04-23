package site.metacoding.everytimeclone.domain.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT * FROM course WHERE name = :name", nativeQuery = true)
    Optional<Course> findByName(@Param("name") String name);

}

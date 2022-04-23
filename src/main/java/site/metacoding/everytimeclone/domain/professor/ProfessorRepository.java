package site.metacoding.everytimeclone.domain.professor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query(value = "SELECT * FROM professor WHERE name = :name", nativeQuery = true)
    Optional<Professor> findByName(@Param("name") String name);

}

package site.metacoding.everytimeclone.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username=:username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM user WHERE nickname=:nickname", nativeQuery = true)
    Optional<User> findByNickname(@Param("nickname") String nickname);

    @Query(value = "SELECT * FROM user WHERE username=:username AND password=:password", nativeQuery = true)
    Optional<User> mLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * FROM user WHERE email=:email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM user WHERE username=:username AND email=:email", nativeQuery = true)
    Optional<User> findByUsernameAndEmail(@Param("username") String username, @Param("email") String email);
}

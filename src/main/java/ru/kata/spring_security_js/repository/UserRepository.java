package ru.kata.spring_security_js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import ru.kata.spring_security_js.model.User;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u join fetch u.roles where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}

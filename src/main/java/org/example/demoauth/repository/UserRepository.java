package org.example.demoauth.repository;

import jakarta.validation.constraints.NotBlank;
import org.example.demoauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}

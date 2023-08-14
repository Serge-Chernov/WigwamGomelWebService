package com.example.vigwamgomel.repository;

import com.example.vigwamgomel.entity.User;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);

}

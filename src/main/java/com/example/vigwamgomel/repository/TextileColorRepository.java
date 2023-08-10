package com.example.vigwamgomel.repository;

import com.example.vigwamgomel.entity.TextileColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TextileColorRepository extends JpaRepository<TextileColor, Long> {
    Optional<TextileColor> findByName(String name);

    Optional<TextileColor> findById(Long id);
}

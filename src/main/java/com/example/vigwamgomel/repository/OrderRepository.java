package com.example.vigwamgomel.repository;

import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select u from Order u where u.username = :username")
    Optional<Order> findByUsername(String username);
}

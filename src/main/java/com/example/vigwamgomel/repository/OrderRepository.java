package com.example.vigwamgomel.repository;

import com.example.vigwamgomel.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

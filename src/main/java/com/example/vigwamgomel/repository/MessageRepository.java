package com.example.vigwamgomel.repository;

import com.example.vigwamgomel.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select u from Message u where u.recipientId = :recipientId")
    public List<Message> findByRecipientId(long recipientId);
}

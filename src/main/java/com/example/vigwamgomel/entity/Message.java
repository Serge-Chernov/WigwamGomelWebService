package com.example.vigwamgomel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean notRead;
    private long recipientId;
    private String message;
    private String date;

    public Message() {
    }

    public Message(long id, boolean notRead, long recipientId, String message, String date) {
        this.id = id;
        this.notRead = notRead;
        this.recipientId = recipientId;
        this.message = message;
        this.date = date;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNotRead() {
        return notRead;
    }

    public void setNotRead(boolean notRead) {
        this.notRead = notRead;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessageText() {
        return message;
    }

    public void setMessageText(String messageText) {
        this.message = messageText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  date + " " + message;
    }
}

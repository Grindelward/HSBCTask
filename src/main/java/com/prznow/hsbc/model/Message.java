package com.prznow.hsbc.model;

import java.time.LocalDateTime;

public class Message {
    private User author;
    private LocalDateTime timestamp;
    private String message;

    public Message(User author, String message) {
        this.author = author;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}

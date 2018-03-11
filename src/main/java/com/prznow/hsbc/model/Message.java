package com.prznow.hsbc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Message implements Comparable{
    private User author;
    private LocalDateTime timestamp;

    @NotEmpty
    @Size(max=140)
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

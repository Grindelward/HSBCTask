package com.prznow.hsbc.model;

import java.util.HashSet;

public class User {
    private Integer id;
    private String username;
    private HashSet<User> followed;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.followed = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashSet<User> getFollowed() {
        return followed;
    }

    public void setFollowed(HashSet<User> followed) {
        this.followed = followed;
    }

    public void addFollowed(User user) {
        this.followed.add(user);
    }
}

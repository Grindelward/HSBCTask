package com.prznow.hsbc.model;

public class Follower {
    private User user;
    private User follower;

    public Follower(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollowe() {
        return follower;
    }

    public void setFollowe(User follower) {
        this.follower = follower;
    }
}

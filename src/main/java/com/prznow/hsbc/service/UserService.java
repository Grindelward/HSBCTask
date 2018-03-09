package com.prznow.hsbc.service;

import com.prznow.hsbc.model.Follower;
import com.prznow.hsbc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>();
    private HashSet<Follower> followers = new HashSet<>();

    public UserService() {
        User texugo = new User(1, "Texugo");
        User testUser = new User(2, "TestUser");
        users.add(texugo);
        users.add(testUser);
    }

    public Optional<User> getUserById(Integer id){
        return users.stream().
                filter(u -> u.getId().equals(id)).
                findFirst();
    }

    public Optional<User> getUserByUsername(String username){
        return users.stream().
                filter(u -> u.getUsername().equals(username)).
                findFirst();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findOrCreate(String username) {
        Optional<User> user =  this.getUserByUsername(username);
        return  user.isPresent() ? user.get() : this.createNewUser(username);
    }

    private User createNewUser(String username){
        User newUser = new User(users.size()+1, username);
        users.add(newUser);
        return newUser;
    }

    public void followUser(User user, User followed){
        Follower follower = new Follower(user, followed);

        if(!(user == null || followed == null) && !followers.contains(follower)) {

            followers.add(new Follower(user, followed));
        }
    }

    public HashSet<Follower> getFollowers() {
        return followers;
    }
}
//http://localhost:8080/users/Texugo/follow/TestUser
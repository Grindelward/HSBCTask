package com.prznow.hsbc.service;

import com.prznow.hsbc.error.CannotFindUserException;
import com.prznow.hsbc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>();

    public UserService() {
        User texugo = new User(1, "Texugo");
        User testUser = new User(2, "TestUser");
        users.add(texugo);
        users.add(testUser);
    }

    public User getUserById(Integer id) throws CannotFindUserException {
        try {
            return users.stream().
                    filter(u -> u.getId().equals(id)).
                    findFirst().get();
        } catch (NoSuchElementException ex) {
            throw new CannotFindUserException(id);
        }
    }

    public User getUserByUsername(String username) throws CannotFindUserException {
        try {
            return users.stream().
                    filter(u -> u.getUsername().equals(username)).
                    findFirst().get();
        } catch (NoSuchElementException ex) {
            throw new CannotFindUserException(username);
        }

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findOrCreate(String username) {
        try {
            return this.getUserByUsername(username);
        } catch (CannotFindUserException ex){
            return this.createNewUser(username);
        }

    }

    private User createNewUser(String username) {
        User newUser = new User(users.size() + 1, username);
        users.add(newUser);
        return newUser;
    }

    public void followUser(User user, User followed) {
        user.addFollowed(followed);
    }

    public HashSet<User> getFollowed(User user) {
        return user.getFollowed();
    }


}
//http://localhost:8080/users/Texugo/follow/TestUser
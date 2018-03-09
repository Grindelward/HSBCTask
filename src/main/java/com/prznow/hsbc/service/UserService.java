package com.prznow.hsbc.service;

import com.prznow.hsbc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}

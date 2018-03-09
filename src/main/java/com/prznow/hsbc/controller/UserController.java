package com.prznow.hsbc.controller;

import com.prznow.hsbc.model.Follower;
import com.prznow.hsbc.model.User;
import com.prznow.hsbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public ArrayList<User> getAll(){
        return userService.getUsers();
    }

    @RequestMapping("/followers")
    public HashSet<Follower> getAllFollowers(){
        return userService.getFollowers();
    }

    @RequestMapping("/byId/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping("/byUsername/{username}")
    public Optional<User> getUser(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/{user}/follow/{followed}", method = RequestMethod.GET)
    public void addMessage(@PathVariable String user, @PathVariable String followed){
        userService.followUser(userService.getUserByUsername(user).get(),userService.getUserByUsername(followed).get() );
    }


}

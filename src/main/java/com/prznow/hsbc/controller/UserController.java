package com.prznow.hsbc.controller;

import com.prznow.hsbc.error.CannotFindUserException;
import com.prznow.hsbc.model.User;
import com.prznow.hsbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ArrayList<User> getAll() {
        return userService.getUsers();
    }

    @RequestMapping("/byId/{id}")
    public User getUser(@PathVariable("id") Integer id) throws CannotFindUserException {
        return userService.getUserById(id);
    }

    @RequestMapping("/byUsername/{username}")
    public User getUser(@PathVariable("username") String username) throws CannotFindUserException {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/{username}/follow/{followed}", method = RequestMethod.GET)
    public String followUser(@PathVariable String username, @PathVariable String followed) throws CannotFindUserException {
        userService.followUser(userService.getUserByUsername(username), userService.getUserByUsername(followed));
        return "User " + username + " starts to follow " + followed;
    }

    @RequestMapping("/{username}/followed")
    public HashSet<User> getAllFollowed(@PathVariable String username) throws CannotFindUserException {
        return userService.getFollowed(userService.getUserByUsername(username));
    }


}

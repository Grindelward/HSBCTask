package com.prznow.hsbc.controller;

import com.prznow.hsbc.model.User;
import com.prznow.hsbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/byId/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping("/byUsername/{username}")
    public Optional<User> getUser(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }


}

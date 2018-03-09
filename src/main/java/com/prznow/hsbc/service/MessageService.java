package com.prznow.hsbc.service;

import com.prznow.hsbc.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;

@Service
public class MessageService {
    private LinkedList<Message> messages = new LinkedList<>();

    @Autowired
    private UserService userService;


    public void addMessage(String username, String message){
         messages.add(new Message(userService.findOrCreate(username), message));
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }
}

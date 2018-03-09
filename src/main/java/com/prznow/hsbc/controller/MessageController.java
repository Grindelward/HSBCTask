package com.prznow.hsbc.controller;

import com.prznow.hsbc.model.Message;
import com.prznow.hsbc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/add/{username}", method = RequestMethod.POST)
    public void addMessage(@PathVariable String username, @RequestBody String message){
        messageService.addMessage(username, message);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public LinkedList<Message> getMessages(){
        return messageService.getMessages();
    }

}


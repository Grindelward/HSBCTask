package com.prznow.hsbc.controller;

import com.prznow.hsbc.error.CannotFindUserException;
import com.prznow.hsbc.error.TooLongMessageException;
import com.prznow.hsbc.model.Message;
import com.prznow.hsbc.service.MessageService;
import com.prznow.hsbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public LinkedList<Message> getAll(){
        return messageService.getMessages();
    }

    @RequestMapping(value = "/{username}/add", method = RequestMethod.POST)
    public String addMessage(@PathVariable String username, @RequestBody String message) throws TooLongMessageException {
        messageService.addMessage(username, message);
        return "Message adding successful";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<Message> getOwnMessages(@PathVariable String username) throws CannotFindUserException {
        return messageService.getOwnMessages(userService.getUserByUsername(username));
    }

    @RequestMapping(value = "/{username}/timeline", method = RequestMethod.GET)
    public List<Message> getFollowedMessages(@PathVariable String username) throws CannotFindUserException {
            return messageService.getFollowedMessages(userService.getUserByUsername(username));
    }

}


package com.prznow.hsbc.service;

import com.prznow.hsbc.error.TooLongMessageException;
import com.prznow.hsbc.model.Message;
import com.prznow.hsbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private static final Integer MESSAGE_LENGTH = 140;
    private LinkedList<Message> messages = new LinkedList<>();

    @Autowired
    private UserService userService;

    public void addMessage(String username, String message) throws TooLongMessageException {
        if (message.length() > MESSAGE_LENGTH) {
            throw new TooLongMessageException();
        }
        messages.add(new Message(userService.findOrCreate(username), message));
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getOwnMessages(User user) {
        return messages.stream()
                .filter(m -> m.getAuthor().equals(user))
                .sorted((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp()))
                .collect(Collectors.toList());

    }

    public List<Message> getFollowedMessages(User user) {
        return messages.stream()
                .filter(m -> user.getFollowed().contains(m.getAuthor()))
                .sorted((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp()))
                .collect(Collectors.toList());

    }

}

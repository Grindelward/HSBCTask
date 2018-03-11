package com.prznow.hsbc.service;

import com.prznow.hsbc.error.TooLongMessageException;
import com.prznow.hsbc.model.Message;
import com.prznow.hsbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private MessageService messageService;


    @Test
    public void addMessageTest() throws TooLongMessageException {
        //given
        messageService.setMessages(new LinkedList<>());

        //when
        messageService.addMessage("Texugo", "NewMessage");

        //then
        assertEquals(messageService.getMessages().size(), 1);

    }

    @Test
    public void getMessagesTest() {
        //when
        LinkedList<Message> messages = messageService.getMessages();

        //then
        assertTrue(messages != null);

    }

    @Test
    public void getOwnMessagesTest() {
        //given
        User tester = new User(34, "Tester");
        User dummy = new User(43, "Dummy");
        Message testerMessage1 = new Message(tester, "testerMessage1");
        Message testerMessage2 = new Message(tester, "testerMessage2");
        Message dummyMessage1 = new Message(dummy, "dummyMessage1");
        messageService.addMessage(testerMessage1);
        messageService.addMessage(testerMessage2);
        messageService.addMessage(dummyMessage1);

        //when
        List messages = messageService.getOwnMessages(tester);

        //then
        assertEquals(messages.size(), 2);
        assertTrue(messages.contains(testerMessage1));
        assertTrue(messages.contains(testerMessage2));
    }

    @Test
    public void getFollowedMessagesTest()  {
        //given
        User tester = new User(34, "Tester");
        User dummy = new User(43, "Dummy");
        User followed = new User(466, "Followed");
        Message testerMessage1 = new Message(tester, "testerMessage1");
        Message testerMessage2 = new Message(tester, "testerMessage2");
        Message dummyMessage1 = new Message(dummy, "dummyMessage1");
        Message dummyMessage2 = new Message(dummy, "dummyMessage2");
        Message followedMessage1 = new Message(followed, "followedMessage1");
        Message followedMessage2 = new Message(followed, "followedMessage2");
        messageService.addMessage(testerMessage1);
        messageService.addMessage(testerMessage2);
        messageService.addMessage(dummyMessage1);
        messageService.addMessage(dummyMessage2);
        messageService.addMessage(followedMessage1);
        messageService.addMessage(followedMessage2);
        tester.addFollowed(followed);

        //when
        List messages = messageService.getFollowedMessages(tester);

        //then
        assertEquals(messages.size(), 2);
        assertTrue(messages.contains(followedMessage1));
        assertTrue(messages.contains(followedMessage2));

    }

}

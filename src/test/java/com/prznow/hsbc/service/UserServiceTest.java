package com.prznow.hsbc.service;

import com.prznow.hsbc.error.CannotFindUserException;
import com.prznow.hsbc.model.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void getUserByIdTest() throws CannotFindUserException {
        //when
        User user = userService.getUserById(1);

        //then
        assertEquals(user.getUsername(), "Texugo");

        //when
        user = userService.getUserById(2);

        //then
        assertEquals(user.getUsername(), "TestUser");

    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = CannotFindUserException.class)
    public void getUserByIdDontExixtsTest() throws CannotFindUserException {
        //when
        userService.getUserById(3);
        //then
        expectedEx.expect(CannotFindUserException.class);

    }

    @Test
    public void getUserByUsernameTest() throws CannotFindUserException {
        //when
        User user = userService.getUserByUsername("Texugo");

        //then
        assertEquals(user.getId(), (Integer) 1);

        //when
        user = userService.getUserByUsername("TestUser");

        //then
        assertEquals(user.getId(), (Integer) 2);

    }

    @Test(expected = CannotFindUserException.class)
    public void getUserByUsernameDontExixtsTest() throws CannotFindUserException {
        //when
        userService.getUserByUsername("Dummy");

        //then
        expectedEx.expect(CannotFindUserException.class);

    }

    @Test
    public void findOrCreateTest() {
        //when
        User user = userService.findOrCreate("Texugo");

        //then
        assertEquals((Integer) 1, user.getId());
        assertEquals(userService.getUsers().size(), 2);

        //when
        user = userService.findOrCreate("NewUser");

        //then
        assertEquals((Integer) 3, user.getId());
        assertEquals(userService.getUsers().size(), 3);
    }

    @Test
    public void followUserTest() throws CannotFindUserException {
        //given
        User user = userService.getUserById(1);
        User followed = userService.getUserById(2);

        //when
        userService.followUser(user, followed);

        //then
        assertTrue(user.getFollowed().contains(followed));
        assertFalse(followed.getFollowed().contains(user));

    }

    @Test
    public void getFollowedTest() throws CannotFindUserException {
        //given
        User user = userService.getUserById(1);
        User followed = userService.getUserById(2);
        user.setFollowed(new HashSet<>());

        //when
        HashSet followedSet = userService.getFollowed(user);

        //then
        assertEquals(followedSet.size(), 0);

        //when
        user.addFollowed(followed);
        followedSet = userService.getFollowed(user);

        //then
        assertEquals(followedSet.size(), 1);

    }

}

package com.mvc.controllers.dao;

import com.mvc.models.User;

import java.util.Arrays;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private List<User> userList;

    public UserDAOImpl(List<User> userList) {
        this.userList = userList;
    }

    public UserDAOImpl() {
        userList = Arrays.asList(
                new User("alex@gmail.com", "guest"),
                new User("remy@gmail.com", "guest"),
                new User("oleg@gmail.com", "admin")
        );

    }

    @Override
    public User getUserByUserName(String username) throws Exception {
        return userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }
}

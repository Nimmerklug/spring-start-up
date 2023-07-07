package com.mvc.services;

import com.mvc.controllers.dao.UserDAO;
import com.mvc.models.User;

public class UserService {
    private UserDAO dao;

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public boolean isUserPresent(User user) throws Exception {
        User myUser = dao.getUserByUserName(user.getUsername());
        return myUser != null;
    }
}

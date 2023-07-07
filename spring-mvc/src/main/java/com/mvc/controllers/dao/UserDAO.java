package com.mvc.controllers.dao;

import com.mvc.models.User;

import java.util.List;

public interface UserDAO {
    User getUserByUserName(String username) throws Exception;

    List<User> getUserList();
}

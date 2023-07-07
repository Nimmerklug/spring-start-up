package com.mvc.controllers.dao;

import com.mvc.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserDAOTest {

    private UserDAO dao;

    @BeforeEach
    public void beforeAll() {
        this.dao = new UserDAOImpl();
    }

    @Test
    public void getUserByUserName_Should_Return_True() throws Exception {
        User remy = dao.getUserByUserName("remy@gmail.com");

        Assertions.assertNotNull(remy);
        Assertions.assertEquals("remy@gmail.com", remy.getUsername());
    }

    @Test
    public void getUserByUserName_Should_Null_User() throws Exception {
        User remy = dao.getUserByUserName("jun@gmail.com");

        Assertions.assertNull(remy);
    }

    @Test
    public void getUserList_Contain_All_Users() {
        List<User> allusers = dao.getUserList();
        // contains require method Equals and Hashcode
        Assertions.assertTrue(allusers.contains(new User("remy@gmail.com", "guest")));
    }

}
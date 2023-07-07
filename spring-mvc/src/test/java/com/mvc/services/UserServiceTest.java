package com.mvc.services;

import com.mvc.controllers.dao.UserDAO;
import com.mvc.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock //specifier to the obj that would be Mocked
    private UserDAO dao;
    private UserService service;

    @BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(this); //or add class annotation @ExtendWith(MockitoExtension.class)
        this.service = new UserService(dao);
    }

    @Test
    public void isUserPresent_Should_Return_True() throws Exception {
        //annotate behavior of method with specified arguments that will return our result
        given(dao.getUserByUserName("olga@mail.ru"))
                .willReturn(
                        new User("olga@mail.ru", "guest")
                );

        Assertions.assertTrue(service.isUserPresent(new User("olga@mail.ru")));

        //verify method execution and with which arguments
        verify(dao).getUserByUserName("olga@mail.ru");
    }

    @Test
    public void isUserPresent_Should_Return_False() throws Exception {
        //annotate behavior of method with specified arguments that will return our result
        given(dao.getUserByUserName("olga@mail.ru"))
                .willReturn(
                        null
                );

        Assertions.assertFalse(service.isUserPresent(new User("olga@mail.ru")));
    }

    @Test
    public void isUserPresent_Should_Throw_Exception() throws Exception {
        //annotate behavior of method with specified arguments that will return our result
        given(dao.getUserByUserName(any(String.class)))
                .willThrow(
                        Exception.class
                );

        Assertions.assertThrows(Exception.class,
                () -> dao.getUserByUserName("remy@gmail.com")
        );
    }

    @Test
    void testCaptor() throws Exception {
        given(dao.getUserByUserName(anyString()))
                .willReturn(
                        new User("olga@mail.ru", "guest")
                );

        //when ArgumentCaptor to get the value of argument
        service.isUserPresent(new User("olga@mail.ru", "guest"));
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        //verify method execution and with which arguments
        verify(dao).getUserByUserName(captor.capture());
        String captorArgument = captor.getValue();

        Assertions.assertEquals("olga@mail.ru", captorArgument);
    }

}

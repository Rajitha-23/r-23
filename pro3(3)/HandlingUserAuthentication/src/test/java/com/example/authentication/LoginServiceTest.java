package com.example.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.authentication.models.User;
import com.example.authentication.repositories.UserRepository;
import com.example.authentication.services.LoginService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testAddUser() {

        User user = new User();
        user.setId(1);
        user.setName("Dummy");
        user.setEmail("dummy@dummy.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        assertTrue(loginService.AddUser(user));
    }

    @Test
    public void testAuthenticateUser() {

        User user = new User();
        user.setId(1);
        user.setName("Dummy");
        user.setEmail("dummy@dummy.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        String password = "password";

        assertTrue(loginService.AuthenticateUser(user, password));
    }

}
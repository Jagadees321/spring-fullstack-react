package com.mockito.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mockito.demo.model.User;
import com.mockito.demo.repo.UserRepository;
import com.mockito.demo.service.SumService;
import com.mockito.demo.service.SumServiceCaller;
import com.mockito.demo.service.UserService;

@SpringBootTest(classes = MockitoApplication.class)

class MockitoApplicationTests {

    @Autowired
    private SumServiceCaller sumServiceCaller;

    @MockBean
    private SumService sumService;

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testSumService() {
        int a = 5;
        int b = 3;

        when(sumService.sum(a, b)).thenReturn(a + b);

        int result = sumServiceCaller.callSumService(a, b);

        verify(sumService, times(1)).sum(a, b);
        assertEquals(a + b, result);
    }

    @Test
    public void testCreateUser() {
        User user = new User("John Doe", "john@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        verify(userRepository, times(1)).save(user);
        assertEquals(user, savedUser);
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User user = new User(userId, "John Doe", "john@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUserById(userId);

        verify(userRepository, times(1)).findById(userId);
        assertEquals(user, retrievedUser);
    }
}

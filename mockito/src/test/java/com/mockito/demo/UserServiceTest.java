package com.mockito.demo;

import static org.junit.Assert.assertEquals;
//UserServiceTest.java
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mockito.demo.model.User;
import com.mockito.demo.repo.UserRepository;
import com.mockito.demo.service.UserService;

@SpringBootTest
public class UserServiceTest {

 @MockBean
 private UserRepository userRepository;

 @Autowired
 private UserService userService;

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

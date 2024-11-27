package com.mockito.demo.controller;

import java.util.List;

//UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mockito.demo.model.User;
import com.mockito.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

 private final UserService userService;

 @Autowired
 public UserController(UserService userService) {
     this.userService = userService;
 }

 @PostMapping
 public ResponseEntity<User> createUser(@RequestBody User user) {
     User createdUser = userService.createUser(user);
     return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
 }

 @GetMapping("/{id}")
 public ResponseEntity<User> getUserById(@PathVariable Long id) {
     User user = userService.getUserById(id);
     if (user != null) {
         return new ResponseEntity<>(user, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 @GetMapping
 public ResponseEntity<List<User>> getAllUsers() {
     List<User> users = userService.getAllUsers();
     if (!users.isEmpty()) {
         return new ResponseEntity<>(users, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
 }

}

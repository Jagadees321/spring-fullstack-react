package com.mockito.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockito.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional methods if needed
}

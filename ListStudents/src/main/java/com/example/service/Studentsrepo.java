package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Students;
@Repository
public interface Studentsrepo  extends JpaRepository<Students, Long>{
     
}

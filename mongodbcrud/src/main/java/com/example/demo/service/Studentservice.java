package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Students;
import com.example.demo.repository.StudentRepo;



@Service
public class Studentservice {
    
    @Autowired
    private StudentRepo studentRepo;
    
    public Students saveStudent(Students student) {
        return studentRepo.save(student);
    }
    
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }
    
    public Students getStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }
    
    public Students updateStudent(Students student) {
        return studentRepo.save(student);
    }
    
    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }
    
    // Other service methods
}

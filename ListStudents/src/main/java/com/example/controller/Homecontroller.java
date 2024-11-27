package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Students;
import com.example.service.Studentsrepo;

@RestController
@RequestMapping("/students")
public class Homecontroller {
	
	
	@Autowired
	Studentsrepo studentrepo;
	
	@PostMapping
	@CrossOrigin(origins = "http://127.0.0.1:5501")
    public String savestudentdata(@RequestBody Students student) {
		
		studentrepo.save(student);
		
    	return "data saved";
    }
	
     @GetMapping
     @CrossOrigin(origins = "http://127.0.0.1:5501")
	 public List<Students> getstudentdata() {		
			
	      return studentrepo.findAll() ;
	    }

}

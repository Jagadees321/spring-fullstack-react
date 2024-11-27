package com.mockito.demo.service;

//SumServiceCaller.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumServiceCaller {

 private final SumService sumService;

 @Autowired
 public SumServiceCaller(SumService sumService) {
     this.sumService = sumService;
 }

 public int callSumService(int a, int b) {
     return sumService.sum(a, b);
 }
}

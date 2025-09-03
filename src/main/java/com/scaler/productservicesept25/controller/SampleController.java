package com.scaler.productservicesept25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample") //path till here is http://localhost:8080/sample
public class SampleController {

    @GetMapping("/sayHello") //path till here is http://localhost:8080/sample/sayHello
    public String sample(){
        return "Hello World!";
    }

    @GetMapping("/sayHello2") //path till here is http://localhost:8080/sample/sayHello2
    public String sample2(){
        return "Hello World! 2";
    }
}

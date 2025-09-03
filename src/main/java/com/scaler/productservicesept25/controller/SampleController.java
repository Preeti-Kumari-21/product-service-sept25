package com.scaler.productservicesept25.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample") //path till here is http://localhost:8081/sample
public class SampleController {

    @GetMapping("/sayHello") //path till here is http://localhost:8081/sample/sayHello
    public String sample1(){
        return "Hello World!";
    }

    @GetMapping("/sayHello/{name}") //path till here is http://localhost:8081/sample/sayHello/PreetiKPVasu
    public String sample(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @GetMapping("/sayHello2") //path till here is http://localhost:8081/sample/sayHello2
    public String sample2(){
        return "Hello World! 2";
    }

    @GetMapping("/sayHello3") //path till here is http://localhost:8081/sample/sayHello3?x=10
    public String sample3(@RequestParam("x") int x){
        StringBuilder sb = new StringBuilder(" ");
        for(int i=1; i<=x; i++){
            sb.append("Hello \n");
        }
        return sb.toString();
    }
}

package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    //UC1: Basic GET Request
    @GetMapping
    public String sayHello(){
        return "Hello from BridgeLabz";
    }

    //UC2: GET with Query Parameter
    @GetMapping("/query")
    public String sayHellowithQuery(@RequestParam String name){
        return "Hello " +name+ " from BridgeLabz";
    }


    //UC3: GET with Path Variable

    @GetMapping("/param/{name}")
    public String sayHellowithPath(@PathVariable String name){
        return "Hello " +name+ " from BridgeLabz";
    }


    @PostMapping("/post")
    public String sayHelloWithPost(@RequestBody User user){
        return "Hello "+user.getFirstName()+" "+user.getLastName()+" from BridgeLabz";
    }

    @PutMapping("put/{firstName}")
    public String syHelloWithPut(@PathVariable String firstName,@RequestParam String lastName){

        return "Hello "+ firstName+" "+lastName+" from Bridgelabz";

    }

}

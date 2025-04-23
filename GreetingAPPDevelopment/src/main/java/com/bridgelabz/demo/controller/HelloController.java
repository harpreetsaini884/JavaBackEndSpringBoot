package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greetings")
public class HelloController {
    @Autowired
    private GreetingService service;

    // UC2: GET default greeting
    @GetMapping
    public Map<String, String> defaultGreeting() {
        return Collections.singletonMap("message", service.getDefaultGreeting());
    }

    // UC3: GET custom greeting via query params
    @GetMapping("/custom")
    public Map<String, String> customGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return Collections.singletonMap("message",
                service.getGreeting(firstName, lastName));
    }

    // UC4: POST to create & save a new greeting
    @PostMapping
    public Greeting createGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return service.saveGreeting(firstName, lastName);
    }

    // UC5: GET by ID
    @GetMapping("/{id}")
    public Greeting getById(@PathVariable Long id) {
        return service.getGreetingById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Greeting not found"));
    }

    // UC6: GET list all
    @GetMapping("/all")
    public List<Greeting> listAll() {
        return service.getAllGreetings();
    }

    // UC7: PUT to update an existing greeting
    @PutMapping("/{id}")
    public Greeting update(
            @PathVariable Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return service.updateGreeting(id, firstName, lastName);
    }

    // UC8: DELETE by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGreeting(id);
    }
}

package com.bridgelabz.demo.service;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository repository;

    // UC2: Default greeting
    public String getDefaultGreeting() {
        return "Hello World";
    }

    // UC3: Custom greeting logic
    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return getDefaultGreeting();
        }
    }

    // UC4: Save greeting
    public Greeting saveGreeting(String firstName, String lastName) {
        String msg = getGreeting(firstName, lastName);
        return repository.save(new Greeting(msg));
    }

    // UC5: Find by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return repository.findById(id);
    }

    // UC6: List all
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    // UC7: Update by ID
    public Greeting updateGreeting(Long id, String firstName, String lastName) {
        Greeting existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found"));
        existing.setMessage(getGreeting(firstName, lastName));
        return repository.save(existing);
    }

    // UC8: Delete by ID
    public void deleteGreeting(Long id) {
        repository.deleteById(id);
    }
}

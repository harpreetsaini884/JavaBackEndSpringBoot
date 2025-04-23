package com.bridgelabz.demo;

import com.bridgelabz.demo.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> { }

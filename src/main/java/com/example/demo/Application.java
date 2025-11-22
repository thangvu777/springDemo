package com.example.demo;

import com.example.demo.domain.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final StringService stringService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    Application(StringService stringService){
        this.stringService = stringService;
    }

    @Override
    public void run(String... args) throws Exception {
        IO.println("Results String Service: " + stringService.getLengthAndFrequencyCount());
    }
}

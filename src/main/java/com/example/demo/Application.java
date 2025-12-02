package com.example.demo;

import com.example.demo.domain.service.StringService;
import com.example.demo.domain.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final StringService stringService;
    private final TransactionsService transactionsService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    Application(StringService stringService, TransactionsService transactionsService){
        this.stringService = stringService;
        this.transactionsService = transactionsService;
    }

    @Override
    public void run(String... args) throws Exception {
        // String Service
        IO.println("TEST 1 _ Results String Service Map < length, frequency > : " + stringService.getLengthAndFrequencyCount());
        IO.println("TEST 2 _ Results String Service Partition [ even length , odd length ]: " + stringService.getLengthAndFrequencyCountPartition());

        // Transaction Service
        IO.println("TEST GET SUM of TRANSACTIONS _ Result " + transactionsService.getTotalSumOfBuy().toString());
    }
}

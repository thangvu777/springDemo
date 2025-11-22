package com.example.demo.domain.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StringService {
    private final List<String> strings = List.of("i don't know" ,"i don't know", "appears once", "appears three times", "appears three times", "appears three times");

    public Map<Integer, Long> getLengthAndFrequencyCount() {
        return strings.stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.counting()
                        )
                );
    }
}

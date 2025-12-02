package com.example.demo.domain.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public Map<Boolean, List<String>> getLengthAndFrequencyCountPartition() {
        return strings.stream()
                .collect(
                        Collectors.partitioningBy(str -> str.length() % 2 == 0,
                                Collectors.toCollection(LinkedList::new)
                        )
                );
    }
}

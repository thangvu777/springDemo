package com.example.demo.domain.service;

import com.example.demo.domain.repository.TransactionRepository;
import com.example.demo.domain.vo.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Service
public class TransactionsService {

    private final TransactionRepository transactionRepository;
    private final String T_COMPLETED = "COMPLETED";
    private final String T_BUY = "BUY";

    @Autowired
    public TransactionsService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public BigDecimal getTotalSumOfBuy(){
        return  transactionRepository.findAll().stream()
                .filter(Objects::nonNull)
                .filter(t-> Objects.nonNull(t.status()) || Objects.nonNull(t.type()))
                .filter(t -> t.type().equals(T_BUY) && t.status().equals(T_COMPLETED))
                .map(TransactionVO::amount)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add);
    }

    public TransactionVO save(TransactionVO transactionVO){
        return transactionRepository.postTransaction(transactionVO);
    }

    public TransactionVO findById(BigInteger transactionId){
        return transactionRepository.findAll()
                .stream()
                .filter(t-> t.id().equals(transactionId))
                .findFirst()
                .orElse(null);
    }
}

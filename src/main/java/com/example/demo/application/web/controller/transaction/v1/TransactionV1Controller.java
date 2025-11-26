package com.example.demo.application.web.controller.transaction.v1;

import com.example.demo.domain.service.TransactionsService;
import com.example.demo.domain.vo.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Controller
@RequestMapping("/api/v1/transactions")
public class TransactionV1Controller {

    private final TransactionsService transactionsService;

    @Autowired
    public TransactionV1Controller(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<TransactionVO> postTransactions (@RequestBody TransactionVO transactionVO) {
        if(transactionVO.amount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            IO.println("HIGH_TRADE_VALUE: " + transactionVO.toString());
            return ResponseEntity.accepted().body(transactionsService.save(transactionVO));
        } else if (transactionVO.amount().compareTo(BigDecimal.valueOf(10000)) < 0) {
            return ResponseEntity.badRequest().body(transactionVO);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(transactionsService.save(transactionVO));
        }
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionVO> getTransactionById(@PathVariable BigInteger transactionId){
        TransactionVO transactionVO =  transactionsService.findById(transactionId);
        return transactionVO!= null? ResponseEntity.ok(transactionVO) :  ResponseEntity.noContent().build();
    }
}

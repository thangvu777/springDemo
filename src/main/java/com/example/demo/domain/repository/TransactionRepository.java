package com.example.demo.domain.repository;

import com.example.demo.domain.vo.TransactionVO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private List<TransactionVO> transactions = new ArrayList<>(List.of(
            new TransactionVO(BigInteger.valueOf(1), "BUY", BigDecimal.valueOf(100), "COMPLETED"),
            new TransactionVO(BigInteger.valueOf(2), "SELL", BigDecimal.valueOf(105), "FAILED"),
            new TransactionVO(BigInteger.valueOf(3), "COMPLETED", BigDecimal.valueOf(200), "FAILED"),
            new TransactionVO(null,null,null,null)
//            new TransactionVO(null,"BUY",null,null),
//            new TransactionVO(null,"BUY",null,"COMPLETED"),
//            new TransactionVO(null,null,null,"COMPLETED")
    ));

    public List<TransactionVO> findAll() {
        return transactions;
    }

    public TransactionVO postTransaction(TransactionVO transactionVO) {
        transactions.add(transactionVO);
        return transactionVO;
    }
}

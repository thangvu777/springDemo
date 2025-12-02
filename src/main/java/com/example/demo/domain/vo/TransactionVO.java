package com.example.demo.domain.vo;

import java.math.BigDecimal;
import java.math.BigInteger;

public record TransactionVO (BigInteger id, String type, BigDecimal amount, String status) {
}

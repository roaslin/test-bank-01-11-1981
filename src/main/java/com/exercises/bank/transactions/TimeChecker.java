package com.exercises.bank.transactions;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TimeChecker {
    boolean isInvalidTransaction(Transaction transaction) {
        return Math.abs(transaction.getTimestamp() - LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)) > 60;
    }
}
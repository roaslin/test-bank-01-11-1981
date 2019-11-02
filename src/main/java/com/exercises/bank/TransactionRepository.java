package com.exercises.bank;

import org.springframework.stereotype.Service;

@Service
public class TransactionRepository {
    private Transaction values;

    public void store(Transaction transaction) {
        this.values= transaction;
    }

    public Transaction getValues() {
        return values;
    }
}

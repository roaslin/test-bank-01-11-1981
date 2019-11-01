package com.exercises.bank;

import org.springframework.stereotype.Service;

@Service
public class PostTransactionService {
    private final TransactionRepository repository;

    public PostTransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void storeTransaction(Transaction transaction) {

        repository.store(transaction);
    }
}

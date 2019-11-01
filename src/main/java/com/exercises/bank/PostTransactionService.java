package com.exercises.bank;

import org.springframework.stereotype.Service;

@Service
public class PostTransactionService {
    private final TransactionRepository repository;
    private final TimeChecker timeChecker;

    public PostTransactionService(TransactionRepository repository, TimeChecker timeChecker) {
        this.repository = repository;
        this.timeChecker = timeChecker;
    }

    public void storeTransaction(Transaction transaction) {
        if (timeChecker.isInvalidTransaction(transaction)) {
            throw new NonValidTransactionException();
        }

        repository.store(transaction);
    }
}

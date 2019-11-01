package com.exercises.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostTransactionServiceShould {

    @Mock
    private TransactionRepository repository;

    private PostTransactionService service;

    @BeforeEach
    void setUp() {
        service = new PostTransactionService(repository);
    }

    @Test
    public void store_a_valid_transaction() {
        Transaction transaction = new Transaction();

        service.storeTransaction(transaction);

        verify(repository).store(transaction);
    }
}
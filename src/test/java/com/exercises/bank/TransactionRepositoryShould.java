package com.exercises.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionRepositoryShould {

    private TransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TransactionRepository();
    }

    @Test
    public void store_transaction() {
        Transaction transaction = aTransaction();

        repository.store(transaction);

        assertThat(repository.getValues().getAmount()).isEqualTo(transaction.getAmount());
        assertThat(repository.getValues().getTimestamp()).isEqualTo(transaction.getTimestamp());
    }

    private Transaction aTransaction() {
        return new Transaction(LocalDateTime.of(2019, 11, 2, 18, 0, 0).toEpochSecond(UTC), 123);
    }
}
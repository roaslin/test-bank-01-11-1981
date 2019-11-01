package com.exercises.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostTransactionServiceShould {

    @Mock
    private TransactionRepository repository;

    private PostTransactionService service;

    @BeforeEach
    void setUp() {
        service = new PostTransactionService(repository, new TimeChecker());
    }

    @Test
    public void store_a_valid_transaction() {
        long validTimestamp = LocalDateTime.now().minusSeconds(5).toEpochSecond(UTC);
        Transaction transaction = new Transaction(validTimestamp);

        service.storeTransaction(transaction);

        verify(repository).store(transaction);
    }

    @Test
    public void throw_an_non_valid_transaction_exception_for_a_non_valid_transaction() {
        long inValidTimestamp = LocalDateTime.now().minusMinutes(1).toEpochSecond(UTC);
        Transaction transaction = new Transaction(inValidTimestamp);

        try {
            service.storeTransaction(transaction);
        } catch (NonValidTransactionException ex) {
            assertThat(ex.getClass()).isEqualTo(NonValidTransactionException.class);
        }
    }
}
package com.exercises.bank.transactions;

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
        Transaction transaction = aValidTransaction();

        service.storeTransaction(transaction);

        verify(repository).store(transaction);
    }

    @Test
    public void throw_an_non_valid_transaction_exception_for_a_non_valid_transaction() {
        Transaction transaction = anInvalidTransaction();

        try {
            service.storeTransaction(transaction);
        } catch (NonValidTransactionException ex) {
            assertThat(ex.getClass()).isEqualTo(NonValidTransactionException.class);
        }
    }

    private Transaction aValidTransaction() {
        long validTimestamp = LocalDateTime.now().minusSeconds(5).toEpochSecond(UTC);
        return new Transaction(validTimestamp, 123);
    }

    private Transaction anInvalidTransaction() {
        long inValidTimestamp = LocalDateTime.now().minusMinutes(1).toEpochSecond(UTC);
        return new Transaction(inValidTimestamp, 123);
    }
}
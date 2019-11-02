package com.exercises.bank.transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

class TimeCheckerShould {

    private TimeChecker timeChecker;

    @BeforeEach
    void setUp() {
        timeChecker = new TimeChecker();
    }

    @Test
    public void return_true_for_a_transaction_older_than_60_seconds() {
        Transaction transaction = aTranasctionOlderThan60Seconds();

        boolean result = timeChecker.isInvalidTransaction(transaction);

        assertThat(result).isTrue();
    }

    @Test
    public void return_false_for_a_transaction_no_older_than_60_seconds() {
        Transaction transaction = aTranasctionWithin60Seconds();

        boolean result = timeChecker.isInvalidTransaction(transaction);

        assertThat(result).isFalse();
    }

    private Transaction aTranasctionOlderThan60Seconds() {
        return new Transaction(LocalDateTime.now().minusMinutes(5).toEpochSecond(UTC), 123);
    }

    private Transaction aTranasctionWithin60Seconds() {
        return new Transaction(LocalDateTime.now().minusSeconds(5).toEpochSecond(UTC), 123);
    }
}
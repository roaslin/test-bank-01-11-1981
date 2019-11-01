package com.exercises.bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

class TimeCheckerShould {

    @Test
    public void return_true_for_a_transaction_older_than_60_seconds() {
        Transaction transaction = new Transaction(LocalDateTime.now().minusMinutes(5).toEpochSecond(UTC), 123);
        TimeChecker timeChecker = new TimeChecker();

        boolean result = timeChecker.isInvalidTransaction(transaction);

        assertThat(result).isTrue();
    }

    @Test
    public void return_false_for_a_transaction_no_older_than_60_seconds() {
        Transaction transaction = new Transaction(LocalDateTime.now().minusSeconds(5).toEpochSecond(UTC), 123);
        TimeChecker timeChecker = new TimeChecker();

        boolean result = timeChecker.isInvalidTransaction(transaction);

        assertThat(result).isFalse();
    }
}
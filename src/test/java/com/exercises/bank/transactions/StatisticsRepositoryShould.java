package com.exercises.bank.transactions;

import com.exercises.bank.statistics.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

class StatisticsRepositoryShould {

    private TransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TransactionRepository();
    }


    @Test
    public void compute_statistics_for_one_transaction() {
        Transaction transaction = aTransaction();
        Statistics expectedStatistics = statisticsOfOneTransaction();

        repository.store(transaction);

        assertThat(repository.getValues()).isEqualTo(expectedStatistics);
    }

    @Test
    public void compute_statistics_for_two_transaction() {
        Transaction transaction = aTransaction();
        Statistics expectedStatistics = statisticsOfTwoTransaction();

        repository.store(transaction);
        repository.store(transaction);

        assertThat(repository.getValues()).isEqualTo(expectedStatistics);
    }

    private Statistics statisticsOfOneTransaction() {
        return Statistics.builder()
                    .sum(50)
                    .avg(50)
                    .max(50)
                    .min(50)
                    .count(1)
                    .build();
    }

    private Statistics statisticsOfTwoTransaction() {
        return Statistics.builder()
                .sum(100)
                .avg(50)
                .max(50)
                .min(50)
                .count(2)
                .build();
    }

    private Transaction aTransaction() {
        return new Transaction(LocalDateTime.of(2019, 11, 2, 18, 0, 0).toEpochSecond(UTC), 50);
    }
}
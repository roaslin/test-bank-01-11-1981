package com.exercises.bank.statistics;

import com.exercises.bank.transactions.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetStatisticsServiceShould {

    @Mock
    private TransactionRepository repository;
    private GetStatisticsService service;

    @BeforeEach
    void setUp() {
        service = new GetStatisticsService(repository);
    }

    @Test
    public void return_statistics() {
        Statistics expectedStatistics = Statistics.builder()
                .sum(150)
                .avg(50)
                .max(50)
                .min(50)
                .count(3)
                .build();
        given(repository.getValues()).willReturn(expectedStatistics);

        Statistics statistics = service.getStatistics();

        assertThat(statistics).isEqualTo(expectedStatistics);
    }
}
package com.exercises.bank.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GetStatisticsControllerShould {

    @Mock
    private GetStatisticsService service;

    private GetStatisticsController controller;

    @BeforeEach
    void setUp() {
        controller = new GetStatisticsController(service);
    }

    @Test
    public void return_empty_statistics() {
        Statistics expectedStatistics = Statistics.builder().build();
        given(service.getStatistics()).willReturn(expectedStatistics);

        ResponseEntity<Statistics> statistics = controller.getStatistics();

        assertThat(statistics.getBody()).isEqualTo(expectedStatistics);
    }
}

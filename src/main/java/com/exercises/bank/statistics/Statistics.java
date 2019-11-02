package com.exercises.bank.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Statistics {
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;
}

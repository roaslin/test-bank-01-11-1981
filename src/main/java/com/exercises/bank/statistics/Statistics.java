package com.exercises.bank.statistics;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Statistics {
    private final double sum;
    private final double avg;
    private final double max;
    private final double min;
    private final long count;
}

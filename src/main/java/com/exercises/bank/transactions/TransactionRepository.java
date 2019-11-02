package com.exercises.bank.transactions;

import com.exercises.bank.statistics.Statistics;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepository {
    public Statistics values = Statistics.builder().build();

    public void store(Transaction transaction) {
        values.add(transaction);
    }

    public Statistics getValues() {
        return values;
    }
}

package com.exercises.bank.statistics;

import com.exercises.bank.transactions.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStatisticsService {
    private final TransactionRepository repository;

    @Autowired
    public GetStatisticsService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Statistics getStatistics() {
        return this.repository.getValues();
    }
}

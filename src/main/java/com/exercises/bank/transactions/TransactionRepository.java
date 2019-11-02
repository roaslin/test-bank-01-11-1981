package com.exercises.bank.transactions;

import com.exercises.bank.statistics.Statistics;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepository {
    private Statistics values = Statistics.builder().build();

    public void store(Transaction transaction) {
        add(transaction);
    }

    private void add(Transaction transaction) {
        long count = this.values.getCount() + 1;
        double sum = this.values.getSum() + transaction.getAmount();
        this.values.setCount(count);
        this.values.setSum(sum);
        double avg = this.values.getSum() / this.values.getCount();
        this.values.setAvg(avg);

        if (hasHigherAmount(transaction)) {
            this.values.setMax(transaction.getAmount());
        }
        if (hasLowerAmount(transaction)) {
            this.values.setMin(transaction.getAmount());
        }
    }

    private boolean hasLowerAmount(Transaction transaction) {
        return transaction.getAmount() < this.values.getMin() || this.values.getMin() == 0;
    }

    private boolean hasHigherAmount(Transaction transaction) {
        return transaction.getAmount() > this.values.getMax();
    }

    public Statistics getValues() {
        return values;
    }
}

package com.exercises.bank.statistics;

import com.exercises.bank.transactions.Transaction;
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

    public void add(Transaction transaction) {
        long count = getCount() + 1;
        double sum = getSum() + transaction.getAmount();
        setCount(count);
        setSum(sum);
        double avg = getSum() / getCount();
        setAvg(avg);

        if (hasHigherAmount(transaction)) {
            setMax(transaction.getAmount());
        }
        if (hasLowerAmount(transaction)) {
            setMin(transaction.getAmount());
        }
    }

    public boolean hasLowerAmount(Transaction transaction) {
        return transaction.getAmount() < getMin() || getMin() == 0;
    }

    public boolean hasHigherAmount(Transaction transaction) {
        return transaction.getAmount() > getMax();
    }
}

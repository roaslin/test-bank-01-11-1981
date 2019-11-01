package com.exercises.bank;

public class Transaction {
    private long timestamp;

    public Transaction(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

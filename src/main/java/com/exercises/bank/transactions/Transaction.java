package com.exercises.bank.transactions;

public class Transaction {
    private long timestamp;
    private double amount;

    public Transaction() {
    }

    public Transaction(long timestamp, double amount) {
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

package com.logitrack.entity;

import java.time.LocalDate;

/**
 * Represents a single transaction (deposit or withdrawal) on an account.
 */
class Transaction {
    private final LocalDate date;
    private final int amount;
    private final String type; // "Deposit" or "Withdrawal"
    private final int currentBalance;

    /**
     * Constructs a new Transaction.
     *
     * @param date The date of the transaction.
     * @param amount The absolute amount of the transaction (must be positive).
     * @param type The type of the transaction ("Deposit" or "Withdrawal").
     * @param currentBalance The balance of the account *after* this transaction.
     */
    public Transaction(LocalDate date, int amount, String type, int currentBalance) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.currentBalance = currentBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
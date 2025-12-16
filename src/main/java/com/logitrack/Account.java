package com.logitrack;


import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private final List<Transaction> transactions;
    private int balance;
    private final StatementPrinter printer;
    private final Clock clock;


    // Default constructor (used in production)
    public Account() {
        this(Clock.systemDefaultZone());
    }


    // Constructor used for testing (does NOT change public interface behavior)
    public Account(Clock clock) {
        this.transactions = new ArrayList<>();
        this.balance = 0;
        this.printer = new StatementPrinter();
        this.clock = clock;
    }


    public void deposit(int amount) {
        validatePositive(amount);
        balance += amount;
        recordTransaction(LocalDate.now(clock), amount, "Deposit");
    }


    public void withdraw(int amount) {
        validatePositive(amount);
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        recordTransaction(LocalDate.now(clock), amount, "Withdrawal");
    }


    public void printStatement() {
        printer.print(transactions);
    }


    private void recordTransaction(LocalDate date, int amount, String type) {
        transactions.add(new Transaction(date, amount, type, balance));
    }


    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}
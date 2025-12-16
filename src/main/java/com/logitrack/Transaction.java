package com.logitrack;


import java.time.LocalDate;


public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final String type;
    private final int balance;


    public Transaction(LocalDate date, int amount, String type, int balance) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balance = balance;
    }


    public LocalDate getDate() { return date; }
    public int getAmount() { return amount; }
    public String getType() { return type; }
    public int getBalance() { return balance; }
}
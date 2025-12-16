package com.logitrack;


import java.util.List;


public class StatementPrinter {
    private static final String HEADER = "DATE | AMOUNT | TYPE | BALANCE";


    public void print(List<Transaction> transactions) {
        System.out.println(HEADER);
        for (Transaction t : transactions) {
            System.out.println(format(t));
        }
    }


    private String format(Transaction t) {
        return t.getDate() + " | " +
                t.getAmount() + " | " +
                t.getType() + " | " +
                t.getBalance();
    }
}
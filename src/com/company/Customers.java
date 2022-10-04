package com.company;

import java.util.ArrayList;

public class Customers {

    private String name;
    private double balance;
    private ArrayList<Double> transaction;
    private ArrayList<String> transactionRule;

    public Customers(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transaction = new ArrayList<Double>();
        this.transactionRule = new ArrayList<String>();
        //userTransaction(transaction);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public ArrayList<String> getTransactionRule() {
        return transactionRule;
    }

    public void userTransaction(double transaction) {
        this.transaction.add(transaction);
    }

    public void addFounds(double transaction) {
        this.balance += transaction;
    }

    public void withdrawalFounds(double transactions) {
        if (transactions <= this.balance) {
            this.balance -= transactions;
        }
    }

    public void transactionRule(String transaction) {
        this.transactionRule.add(transaction);
    }

}

package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customers> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customers>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customers(customerName, initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addTransactionRule(String customerName, String rule) {
        Customers customer = findCustomer(customerName);
        if (customer != null) {
            customer.transactionRule(rule);
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transaction) {
        Customers customer = findCustomer(customerName);
        if (customer != null) {
            customer.userTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customers findCustomer(String name) {
        for (int i=0; i<this.customers.size(); i++) {
            Customers customer = this.customers.get(i);
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public boolean addCustomerFounds(String customerName, double transaction) {
        Customers customer = findCustomer(customerName);
        if (customer != null) {
            customer.addFounds(transaction);
            return true;
        }
        return false;
    }

    public boolean withdrawalCustomerFounds(String customerName, double transaction) {
        Customers customer = findCustomer(customerName);
        if (customer != null) {
            customer.withdrawalFounds(transaction);
            return true;
        }
        return false;
    }

}

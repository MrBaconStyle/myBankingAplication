package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branch;

    public Bank(String name) {
        this.name = name;
        this.branch = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branch.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomerBrunch(String branchName, String customerName, double customerTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            return currentBranch.addCustomer(customerName, customerTransaction);
        }
        return false;
    }

    public boolean addTransactionBrunch(String branchName, String customerName, double customerTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            return currentBranch.addTransaction(customerName, customerTransaction);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i=0; i<this.branch.size(); i++) {
            Branch currentBranch = this.branch.get(i);
            if (currentBranch.getName().equals(branchName)) {
                return currentBranch;
            }
        }
        return null;
    }

    public void addBranchCustomerFounds(String branchName, String customerName, double customerTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            boolean state = currentBranch.addCustomerFounds(customerName, customerTransaction);
            if (state) {
                currentBranch.addTransaction(customerName, customerTransaction);
                currentBranch.addTransactionRule(customerName, "payment");
            }
        }
    }

    public void withdrawalBranchCustomerFounds(String branchName, String customerName, double customerTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            boolean state = currentBranch.withdrawalCustomerFounds(customerName, customerTransaction);
            if (state) {
                currentBranch.addTransaction(customerName, customerTransaction);
                currentBranch.addTransactionRule(customerName, "withdrawal");
            }
        }
    }

    public boolean printCustomers(String branchName, boolean showTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            System.out.println("Customer details for branch: " + currentBranch.getName());
            ArrayList<Customers> branchCustomers = currentBranch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                //Customers currentState =
                Customers currentCustomer = branchCustomers.get(i);
                System.out.println("Customer: ");
                System.out.println((i+1) + ". " + branchCustomers.get(i).getName());
                System.out.println("Balance: " + branchCustomers.get(i).getBalance());
                if (showTransaction) {
                    ArrayList<Double> customerTransaction = currentCustomer.getTransaction();
                    ArrayList<String> customerTransactionRule = currentCustomer.getTransactionRule();
                    System.out.println("Transactions: ");
                    for (int j=0; j<customerTransaction.size(); j++) {
                        System.out.println((j+1) + ". " + customerTransactionRule.get(j) + ": "+ customerTransaction.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

}

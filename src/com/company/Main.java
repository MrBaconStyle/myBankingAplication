package com.company;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Konercijalna");

        bank.addBranch("Ustanicka");
        bank.addCustomerBrunch("Ustanicka", "Vuk", 951.45);
        bank.withdrawalBranchCustomerFounds("Ustanicka", "Vuk", 51.45);
        bank.withdrawalBranchCustomerFounds("Ustanicka", "Vuk", 20.5);
        bank.addBranchCustomerFounds("Ustanicka", "Vuk", 11.45);

        bank.printCustomers("Ustanicka", true);
//        bank.addCustomerBrunch("Ustanicka", "Miha", 753.74);
//
//        bank.addBranch("Terazije");
//        bank.addCustomerBrunch("Terazije", "Dule", 789.25);
//
//        bank.addTransactionBrunch("Ustanicka", "Vuk", 25.12);
//        bank.addTransactionBrunch("Ustanicka", "Vuk", -9.25);
//
//        bank.addTransactionBrunch("Ustanicka", "Miha", 5.09);
//
//        bank.addTransactionBrunch("Terazije", "Dule", 44.63);
//
//        bank.printCustomers("Ustanicka", true);

        //bank.printCustomers("Terazije", true);
    }
}

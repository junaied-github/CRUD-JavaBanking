package com.bank;

public class Banking {

    public double getBalance(Customer customer) {
        return customer.getBalance();
    }

    public double setBalance(Customer customer, double balance) {
        return 0;
    }

    public double withdraw(Customer customer, double amount) {
        return 0;
    }

    public double transferMoney(Customer customer, double amount) {
        return 0;
    }

    public double transferHistory(Customer customer) {
        return 0;
    }

}

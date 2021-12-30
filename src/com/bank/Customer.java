package com.bank;

public class Customer {

    private String name;
    private String address;
    private String userName;
    private Integer userId;
    private Double balance;
    private String password;

    public Customer(String name, String address, Integer userID, Double balance, String userName, String password){
        this.name = name;
        this.address = address;
        this.userId = userID;
        if(balance >= 0.0){
            this.balance = balance;
        }
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if(balance > 0.00){
            this.balance += balance;
        }else {
            System.out.println("Incorrect Amount");
        }

    }

    public boolean withdrawBalance(Double balance) {
        if(balance > 0.00 && this.balance >= balance){
            this.balance -= balance;
            return true;
        }else {
            System.out.println("Incorrect Amount");
            return false;
        }
    }
}

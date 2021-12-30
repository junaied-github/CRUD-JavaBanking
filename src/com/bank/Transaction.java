package com.bank;

public class Transaction {
    private String date;
    private Integer userID;
    private Double amount;
    private String type;
    private Integer transferUserID;

    public Transaction(String date, Integer userID, Double amount, String type, Integer transferUserID){
        this.date = date;
        this.userID = userID;
        this.amount = amount;
        this.type = type;
        this.transferUserID = transferUserID;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public Integer getTransferUserID() {
        return transferUserID;
    }
}

package com.bank;

import java.sql.Timestamp;


public class Banking {

    public static void transferMoney(Integer fromCustomerId, Integer toCustomerID, Double amount ) {
        if(Database.customerObject(toCustomerID) != null){
            Customer authCustomer = Database.customerObject(fromCustomerId);
            Customer toCustomer = Database.customerObject(toCustomerID);

            if(authCustomer.withdrawBalance(amount)) {
                String dateTime1 = new Timestamp(System.currentTimeMillis()).toString();
                Database.addTransaction(new Transaction(dateTime1, fromCustomerId, amount, "Out", toCustomerID));
                toCustomer.setBalance(amount);
                String dateTime2 = new Timestamp(System.currentTimeMillis()).toString();
                Database.addTransaction(new Transaction(dateTime2, toCustomerID, amount, "In", fromCustomerId));
            }else{
                System.out.println("Something went wrong!");
            }
        }else {
            System.out.println("Transfer user not found!");
        }
    }

}

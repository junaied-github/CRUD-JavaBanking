package com.bank;
import java.util.ArrayList;

public class Database {
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    private static ArrayList<Executive> executiveList = new ArrayList<Executive>();
    private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

    public static void addCustomer(Customer customer){
        customerList.add(customer);
        System.out.println("New Customer Added");
    }

    public static void allCustomer(){
        for (int i = 0; i < customerList.size(); i++){
            System.out.println((i + 1) + " " + customerList.get(i).getName());
        }
    }

    public static void searchCustomer(Integer customerID){
        Boolean found = false;
        for (int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getUserId() == customerID) {
                found = true;
                System.out.println("Found: " + customerList.get(i).getName());
            }
        }

        if (!found){
            System.out.println("Sorry! Not Found");
        }
    }

    public static void searchCustomer(String customerName){
    }

    public static Integer isValidCustomer(String username, String password) {
        for (int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getUserName().equals(username) && customerList.get(i).getPassword().equals(password)) {
                return customerList.get(i).getUserId();
            }
        }
        return null;
    }

    public static Customer customerObject (Integer customerID){
        for (int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getUserId() == customerID) {
                return customerList.get(i);
            }
        }
        return null;
    }



    public static void addExecutive(Executive executive){
        executiveList.add(executive);
        System.out.println("New Executive Added");
    }

    public static void allExecutive(){
        for (int i = 0; i < executiveList.size(); i++){
            System.out.println((i+1) + " " + executiveList.get(i).getUserName());
        }
    }

    public static String isValidExecutive(String username, String password) {
        for (int i = 0; i < executiveList.size(); i++){
            if(executiveList.get(i).getUserName().equals(username) && executiveList.get(i).getPassword().equals(password)) {
                return executiveList.get(i).getUserName();
            }
        }
        return null;
    }


     public static void addTransaction(Transaction transaction){
        transactionList.add(transaction);
        System.out.println("New Transaction Created.");
    }

    public static void transactionHistory(Integer customerID) {
        for (int i = 0; i < transactionList.size(); i++){
            if(transactionList.get(i).getUserID() == customerID) {
                System.out.println((i + 1) + " Date:" + transactionList.get(i).getDate() +
                        " UserID: " + transactionList.get(i).getTransferUserID() +
                        "Amount: " + transactionList.get(i).getAmount() +
                        "Type: " + transactionList.get(i).getType());
            }
        }
    }


}

package com.bank;

import java.util.Scanner;

public class Main {

    public static Scanner scanner;
    public static int menu;

    private static String adminUsername = "admin";
    private static String adminPassword = "admin";

    private static String inputUsername;
    private static String inputPassword;

    private static Integer authCustomerUserID;

    private static boolean loginStatus = false;

    public static Integer getAuthCustomerID(){
        return authCustomerUserID;
    }


    public static void main(String[] args) {

        do{
            scanner = new Scanner(System.in);

            System.out.println("****  Simple Banking System ****");

            System.out.println("Enter Username: ");
            inputUsername = scanner.nextLine();

            System.out.println("Enter Password: ");
            inputPassword = scanner.nextLine();

            System.out.println("Customer:1 or Executive:2 or Admin:3");
            Integer inputUserType = scanner.nextInt();

            if(inputUserType == 1){
                if( Database.isValidCustomer(inputUsername, inputPassword) != null){
                    authCustomerUserID = Database.isValidCustomer(inputUsername, inputPassword);
                    System.out.println("Welcome To The Bank!");
                    loginStatus = true;
                }else{
                    System.out.println("Wrong username/password.");
                }
            }else if(inputUserType == 2){
                if(Database.isValidExecutive(inputUsername, inputPassword) != null){
                    System.out.println("Welcome To The Bank!!");
                    loginStatus = true;
                }else{
                    System.out.println("Wrong username/password.");
                }

            }else if (inputUserType == 3){
                if(adminPassword.equals(inputPassword) && adminUsername.equals(inputUsername)){
                    System.out.println("Welcome To The Bank Admin!!!");
                    loginStatus = true;
                }else{
                    System.out.println("Wrong username/password.");
                }
            }else{
                System.out.println("Wrong user type.");
            }

            if(loginStatus){
                if(inputUserType == 1){
                    do{
                        System.out.println(
                                "1: Transfer Money"
                                        + "\n2: Transaction History"
                                        + "\n3: Check Balance"
                                        + "\n4: Log Out");

                        scanner = new Scanner(System.in);
                        menu = scanner.nextInt();
                        switch(menu) {
                            case 1:
                                System.out.println("*** Transfer  Money***");
                                Customer authCustomer = Database.customerObject(getAuthCustomerID());
                                System.out.println("Your Current Balance: " + authCustomer.getBalance());
                                scanner = new Scanner(System.in);

                                System.out.println("Enter UserID(Wants to transfer): ");
                                Integer toUserID = scanner.nextInt();

                                System.out.println("Enter Transfer Amount: ");
                                Double transferAmount = scanner.nextDouble();

                                scanner.nextLine();
                                System.out.println("Enter Your Password: ");
                                String authUserPassword = scanner.nextLine();

                                if(authCustomer.getPassword().equals(authUserPassword)){
                                    Banking.transferMoney(getAuthCustomerID(), toUserID, transferAmount);
                                }else{
                                    System.out.println("Incorrect Password");
                                }
                                break;
                            case 2:
                                System.out.println("*** Transaction History ***");
                                Database.transactionHistory(getAuthCustomerID());
                                break;
                            case 3:
                                Customer currentCustomer = Database.customerObject(getAuthCustomerID());
                                System.out.println("Current Balance: " + currentCustomer.getBalance());
                                break;
                            case 4:
                                System.out.println("By By !!! ");
                                loginStatus = false;
                                break;
                            default:
                                System.out.println("Wrong Input");
                        }
                    }while(loginStatus);
                } else if (inputUserType == 2) {
                    do{
                        System.out.println(
                                "1: Customer Add"
                                        + "\n2: Customer List"
                                        + "\n3: Customer Search"
                                        + "\n4: Log Out");

                        scanner = new Scanner(System.in);
                        menu = scanner.nextInt();
                        switch(menu) {
                            case 1:
                                System.out.println("*** Customer Add ***");
                                scanner = new Scanner(System.in);

                                System.out.println("Enter Name: ");
                                String name = scanner.nextLine();

                                System.out.println("Enter Address: ");
                                String address = scanner.nextLine();

                                System.out.println("Enter Customer  Password: ");
                                String customerPassword = scanner.nextLine();

                                System.out.println("Enter UserName: ");
                                String userName = scanner.nextLine();

                                System.out.println("Enter UserID: ");
                                Integer userID = scanner.nextInt();

                                System.out.println("Enter Open Balance: ");
                                Double openBalance = scanner.nextDouble();

                                Database.addCustomer(new Customer(name, address, userID, openBalance, userName, customerPassword));
                                break;
                            case 2:
                                Database.allCustomer();
                                break;
                            case 3:
                                System.out.println("*** Customer Search ***");
                                scanner = new Scanner(System.in);

                                System.out.println("Enter UserID: ");
                                Integer customerUserID = scanner.nextInt();

                                Database.searchCustomer(customerUserID);
                                break;
                            case 4:
                                System.out.println("By By !!! ");
                                loginStatus = false;
                                break;
                            default:
                                System.out.println("Wrong Input");
                        }
                    }while(loginStatus);
                } else {
                    do{
                        System.out.println(
                                "1: Bank Executive Registration"
                                        + "\n2: Customer Add"
                                        + "\n3: Customer List"
                                        + "\n4: Customer Search"
                                        + "\n5: Log Out");

                        scanner = new Scanner(System.in);
                        menu = scanner.nextInt();
                        switch(menu) {
                            case 1:
                                System.out.println("*** Bank Executive Registration ***");
                                scanner = new Scanner(System.in);

                                System.out.println("Enter UserName: ");
                                String exUserName = scanner.nextLine();

                                System.out.println("Enter Password: ");
                                String password = scanner.nextLine();

                                System.out.println("Retype  Password: ");
                                String retypePassword = scanner.nextLine();

                                if(password.equals(retypePassword)){
                                    Database.addExecutive(new Executive(exUserName, password));
                                }else{
                                    System.out.println("Sorry! Password Mismatch.");
                                }

                                break;
                            case 2:
                                System.out.println("*** Customer Add ***");
                                scanner = new Scanner(System.in);

                                System.out.println("Enter Name: ");
                                String name = scanner.nextLine();

                                System.out.println("Enter Address: ");
                                String address = scanner.nextLine();

                                System.out.println("Enter Customer  Password: ");
                                String customerPassword = scanner.nextLine();

                                System.out.println("Enter UserName: ");
                                String userName = scanner.nextLine();

                                System.out.println("Enter UserID: ");
                                Integer userID = scanner.nextInt();

                                System.out.println("Enter Open Balance: ");
                                Double openBalance = scanner.nextDouble();

                                Database.addCustomer(new Customer(name, address, userID, openBalance, userName, customerPassword));
                                break;
                            case 3:
                                Database.allCustomer();
                                break;
                            case 4:
                                System.out.println("*** Customer Search ***");
                                scanner = new Scanner(System.in);

                                System.out.println("Enter UserID: ");
                                Integer customerUserID = scanner.nextInt();

                                Database.searchCustomer(customerUserID);
                                break;
                            case 5:
                                System.out.println("By By !!! ");
                                loginStatus = false;
                                break;
                            default:
                                System.out.println("Wrong Input");
                        }
                    }while(loginStatus);
                }
            }
        }while(true);
    }
}

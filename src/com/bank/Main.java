package com.bank;

import java.util.Scanner;

public class Main {

    public static Scanner scanner;
    public static int menu;

    private static String adminUsername = "admin";
    private static String adminPassword = "admin";

    private static String inputUsername;
    private static String inputPassword;

    private static boolean loginStatus = false;


    public static void main(String[] args) {

        do{
            scanner = new Scanner(System.in);

            System.out.println("****  Simple Banking System ****");

            System.out.println("Enter Username: ");
            inputUsername = scanner.nextLine();

            System.out.println("Enter Password: ");
            inputPassword = scanner.nextLine();

            if(inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)){
                System.out.println("Welcome Admin!");
                loginStatus = true;
            }else{
                System.out.println("Wrong username/password.");
            }

            if(loginStatus){
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
                            System.out.println("Bank Executive Registration: ");
                            break;
                        case 2:
                            System.out.println("Customer Add: ");
                            break;
                        case 3:
                            System.out.println("Customer List: ");
                            break;
                        case 4:
                            System.out.println("Customer Search: ");
                            break;
                        case 5:
                            System.out.println("By By Admin !!! ");
                            loginStatus = false;
                            break;
                    }
                }while(loginStatus);
            }
        }while(true);

    }
}

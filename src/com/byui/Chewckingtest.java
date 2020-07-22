package com.byui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Chewckingtest {


    public static void main(String[] args) {
        //main variables
        String name;
        char createOrNot;
        //user input getter
        Scanner input= new Scanner(System.in);
        //program info
       System.out.println(" Program info");
       //name
       System.out.print("Please enter you full name: ");
       name = input.nextLine();
       //create accounts if desired
       System.out.print(name + "Would you like to add an checking account Y/N?");
       createOrNot= input.next().charAt(0);
       //checking
       if(createOrNot == 'y'|| createOrNot =='Y'){
           createChecking(name, input);
           //savings
       }else if(createOrNot == 'n' || createOrNot =='N'){
           //createSavings(name,input);
       }
       // if answer not y or n
       else{
           System.out.println("input must be Y or N.");
       }
       //Read Accounts.txt file
        File dataFile = new File("Accounts.txt");
        try (Scanner data = new Scanner(dataFile)) {
            while (data.hasNextLine()) {
                String line = data.nextLine().trim();
                System.out.print(line);
            }
            //Error message for Reading Accounts.txt file
        } catch (IOException e) {
            System.out.println("Error reading the data");
        }
    }

    /**
     *
     * @param name of user for accounts
     * @param input user input
     */
    public static void createChecking(String name, Scanner input){
        //checking variables
        ArrayList<Double> expenses =new ArrayList<>();
        double balance = 0;
        double income;
        char depositOrNot;
        int numberOfExpenses;
        // account balance
        System.out.print("What is your Checking Account current balance? ");//TODO CREATE AN TRY CATCH iNPUT.MISMATCH
        balance= input.nextDouble();
        // deposit more $$
        System.out.print("DO wish to make an deposit y/n? ");
        depositOrNot = input.next().charAt(0);
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            System.out.print("Enter amount wish to deposit");//TODO CREATE AN TRY CATCH iNPUT.MISMATCH
            income = input.nextDouble();
            balance += income;//TODO change name to amount
        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            income = 0;
        }else {
            System.out.println("input must be Y or N.");
        }
        //user expenses
        System.out.print("Do you have any bills or expenses to pay Y/N ");
        depositOrNot = input.next().charAt(0);
        //number of user expenses
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            System.out.print("Enter the number of different expenses ");
            numberOfExpenses = input.nextInt();
            //cost of each expense
            for(int i =0;i <= numberOfExpenses;i++){
                System.out.println("enter Expense");
                income= input.nextDouble();
                expenses.add(income);
            }
        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            numberOfExpenses = 0;
        }else{
            System.out.println("input must be Y or N.");
        }
        //write given info by the user to Accounts.txt
        try (java.io.PrintWriter myFile = new PrintWriter("Accounts.txt")) {
            myFile.printf(name + balance);
            //error writing to Accounts.txt file
        }catch (IOException e) {
            System.out.println("File cannot be opened");
        }

        //Checking.displayObject(new Checking(expenses,name,balance));

    }

}

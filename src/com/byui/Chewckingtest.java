package com.byui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Chewckingtest {


    public static void main(String[] args) {
        String name;
        char createOrNot;

        Scanner input= new Scanner(System.in);

       System.out.println(" Program info");
       System.out.print("Please enter you full name: ");
       name = input.nextLine();
       System.out.print(name + "Would you like to add an checking account Y/N?");
       createOrNot= input.next().charAt(0);
       if(createOrNot == 'y'|| createOrNot =='Y'){
           createChecking(name, input);
       }//else if(createOrNot == 'n' || createOrNot =='N'){
           //createSavings(name,input);
       //}
       else{
           System.out.println("input must be Y or N.");
       }
        File dataFile = new File("Accounts.txt");
        try (Scanner data = new Scanner(dataFile)) {
            while (data.hasNextLine()) {
                String line = data.nextLine().trim();
                System.out.print(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the data");
        }
    }
    public static void createChecking(String name, Scanner input){
        ArrayList<Double> expenses =new ArrayList<>();
        double balance = 0;
        double amount;
        char depositOrNot;
        int numberOfExpenses = 0;
        double expensesTotal = 0;

        System.out.print("What is your Checking Account current balance? ");
        balance= input.nextDouble();
        System.out.print("DO wish to make an deposit y/n? ");
        depositOrNot = input.next().charAt(0);
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            System.out.print("Enter amount wish to deposit");
            amount = input.nextDouble();
            balance += amount;//TODO fix deposit object pass
        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            amount = 0;
        }else{
            System.out.println("input must be Y or N.");
        }
        System.out.print("Do you have any bills or expenses to pay Y/N ");
        depositOrNot = input.next().charAt(0);
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            System.out.print("Enter the number of different expenses ");
            numberOfExpenses = input.nextInt();
            for(int i =0;i <= numberOfExpenses;i++){
                System.out.println("enter Expense");
                amount= input.nextDouble();
                expenses.add(amount);
            }

        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            numberOfExpenses = 0;
        }else{
            System.out.println("input must be Y or N.");
        }

        for(double ex : expenses){
            expensesTotal += ex;
        }
        //expenses file write and read
        try (java.io.PrintWriter myFile = new PrintWriter("Accounts.txt")) {
            myFile.println(name + balance);
        }catch (IOException e) {
            System.out.println("File cannot be opened");
        }
        Account.displayObject(new Checking(expenses,name,balance));
    }

}

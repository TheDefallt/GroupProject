package com.byui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;

/**
 * Pesudo Code
 * tell the user what the program does
 * Prompt the user to INPUT full name
 * <p>
 * Ask the user if they Want to start a checking
 * IF user INPUT is yes
 * * checking account info
 * SCAN user input for Account Balance
 * GENERATE account Number for user account
 * Ask user if they have expenses
 * IF yes Ask how many different expenses the user have
 * DO Prompt user to enter expense amount and store it into expense  ARRAY
 * WHILE CREATE file expenseData.txt
 * CATCH ERROR file missing can not be created
 * FOR each expense input WRITE it to expenseData.txt
 * CATCH ERROR file cannot be opened
 * then READ all the expense inputs in expenseData.txt
 * CATCH ERROR reading the data
 * WHILE finding the total amount of expenses
 * SHOW name, account Number,starting balance,total expense, and current balance
 * <p>
 * ELSE IF user INPUT is no
 * proceed to the rest of the program
 * ElSE
 * ERROR prompt user to enter yes no
 * Ask the user if they Want to start a checking
 * IF user INPUT is yes
 * * savings account info
 * SCAN user input for Account Balance
 * GENERATE account Number for user account
 * SCAN user INPUT APR
 * Calculate the worth of savings account in an year
 * SHOW name, account Number,starting balance,APR, and projected balance
 * ELSE IF user INPUT is no
 * proceed to the rest of the program
 * ElSE
 * ERROR prompt user to enter yes no
 * SHOW accounts overview
 * SHOW goodbye message
 */

public class Main {
    public static void main(String[] args) {

        //Program prologue
        System.out.println("This program will all you to enter information about a new checking or savings account \n" +
                "that you would like to start. It will then read the information back to you for confirmation, and estimate \n" +
                "how much money your savings account will gain with regular contribution and the given APY rate over five years. \n");

        //User input getter
        Scanner input = new Scanner(System.in);

        //Prompt that asks the user for their full name, and store in a local variable
        System.out.println("Please enter you full name: ");
        String name = input.nextLine();

        /*------Start Creating Checking account--------*/

        //Checking account variables that will later be used in a parameterized constructor to build the checking account object.
        ArrayList<Double> expenses = new ArrayList<>();
        double balance = 0;
        double income;
        char depositOrNot;
        int numberOfExpenses;

        //Ask the user what the current balance of the checking account is
        try {
            System.out.println("What is your current checking account balance? ");
            balance = input.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Error: input must be an dollar value.");
            System.exit(0);
        }

        //Ask if the user would like to make a deposit at this time.
        System.out.println("Do wish to make an deposit Y/N? ");
        depositOrNot = input.next().charAt(0);
        if (depositOrNot == 'y' || depositOrNot == 'Y') {
            try {
                System.out.println("Enter the amount you wish to deposit. ");
                income = input.nextDouble();
                balance += income;
            } catch (InputMismatchException ex) {
                System.out.println("Error: input must be an dollar value.");
                System.exit(0);
            }

        } else if (depositOrNot == 'n' || depositOrNot == 'N') {
            income = 0;
        } else {
            System.out.println("Input must be Y or N.");
            System.exit(0);
        }

        //Asks the user how many expenses they have to pay, generates a loop for that number, and asks for the amount of each expense.
        System.out.println("Do you have any bills or expenses to pay Y/N ");
        depositOrNot = input.next().charAt(0);
        if (depositOrNot == 'y' || depositOrNot == 'Y') {
            System.out.println("Enter the number of different expenses ");
            numberOfExpenses = input.nextInt();
            for (int i = 0; i < numberOfExpenses; i++) {
                System.out.println("Enter expense amount: ");
                expenses.add(input.nextDouble());
            }
        } else if (depositOrNot == 'n' || depositOrNot == 'N') {
            numberOfExpenses = 0;
        } else {
            System.out.println("Input must be Y or N.");
            System.exit(0);
        }

        Checking userChecking = new Checking(expenses, name, balance);

        /*---------Start creating Savings account-------------*/

        //Creates a new savings account using a no-arg constructor
        Savings userSavings = new Savings();

        //Sets the name of the customer for the savings account that was collected earlier.
        userSavings.setName(name);

        //Asks the user for the beginning balance of their savings account.
        try {
            System.out.println("What is the beginning balance that you would like to add to your savings account? ");
            userSavings.setBalance(input.nextDouble());
        } catch (InputMismatchException ex) {
            System.out.println("Error: input must be an dollar value.");
            System.exit(0);
        }

        //Asks the user how much they plan on contributing to their account on a monthly basis
        try {
            System.out.println("What is the amount, if any, that will be contributed to your savings account monthly? ");
            userSavings.setIncome(input.nextDouble());
        } catch (InputMismatchException ex) {
            System.out.println("Error: input must be an dollar value.");
            System.exit(0);
        }

        //Asks the user what the current Annual Percentage Yield is.
        try {
            System.out.println("What is the current annual percentage yield? Please use the decimal expression of the" +
                    "percentage (ie .01 for 1%) ");
            userSavings.setAnnualPercentageYield(input.nextDouble());
        } catch (InputMismatchException ex) {
            System.out.println("Error: input must be a decimal percentage.");
            System.exit(0);
        }

        //Creates a new file to write account data to.
        java.io.File file = new java.io.File("accounts.txt");

        //Create a new print writer to write to the file when accounts are being created.
        try {
            //New PrintWriter object
            PrintWriter output = new PrintWriter(file);

            //Writes all data from the checking object to the opened file.
            output.println(userChecking.getName());
            output.println(userChecking.getAcctNum());
            output.println(userChecking.getBalance());
            output.println(userChecking.getIncome());
            output.println(userChecking.getTotalExpenses());

            //Writes all data from the savings object to the opened file.
            output.println(userSavings.getAcctNum());
            output.println(userSavings.getBalance());
            output.println(userSavings.getIncome());
            output.println(userSavings.getAnnualPercentageYield());

            output.close();
        }catch (Exception ex) {
            /*Exception that throws an error if the file cannot be read or does not exits and closes the program.*/
            System.out.println("Unable to write to data file.");
            System.exit(-1);
        }

        //Try catch statement that attempts to read from the created file.
        try {
            /*New Scanner object using earlier created file*/
            Scanner fileRead = new Scanner(file);

            /*Output messages that shows all relevant Savings account data and calculates totals for the next 5 years.*/
            System.out.println("Client's name: " + fileRead.next());
            System.out.println("Checking account number: " + fileRead.nextInt());
            System.out.println("Checking account balance: " + (fileRead.nextDouble() + fileRead.nextDouble()));
            System.out.println("Estimated monthly expenses: " + fileRead.nextDouble());
            System.out.println("Savings account number: " + fileRead.nextInt());
            double runningBalance = fileRead.nextDouble();
            System.out.println("Savings account beginning balance: " + runningBalance);
            double monthlyContribution = fileRead.nextDouble();
            double apy = fileRead.nextDouble();
            for(int i = 0; i < 5; i++){
                runningBalance += Savings.calculateBalance(runningBalance, monthlyContribution, apy);
                System.out.printf("End of Year " + (i + 1) + " balance: %4.2f \n", runningBalance);
            }

            //Goodbye message
            System.out.println("Goodbye");

            //Closes all resources that are still open.
            fileRead.close();
        } catch (Exception ex) {
            /*Exception that throws an error if the file cannot be read or does not exits and closes the program.*/
            System.out.println("Unable to read data file.");
            System.exit(-1);
        }
    }
}


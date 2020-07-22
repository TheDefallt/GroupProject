package com.byui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     *
     * @param args Program that collects and creates bank account information to help manage said created accounts
     */

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
    public static void main(String[] args) {
        //Temporary variable to store user's name
        String name;
        //Store user's responses to creating accounts
        char createOrNot;
        //User input getter
        Scanner input = new Scanner(System.in);
        //name
        System.out.print("Please enter you full name: ");
        name = input.nextLine();
        //create accounts if desired
        System.out.print(name + " Would you like to add an checking account? Y/N");
        createOrNot = input.next().charAt(0);

        //Checking start, Ask if user would like to create a Checking account.
        if (createOrNot == 'y' || createOrNot == 'Y') {
            createChecking(name, input);
        } else if (createOrNot == 'n' || createOrNot == 'N') {

        }
        // if answer not y or n
        else {
            System.out.println("input must be Y or N.");
        }

        //Savings start, Ask if user would like to create a Savings account.
        System.out.println(name + " Would you like to add a savings account? Y/N");
        createOrNot = input.next().charAt(0);

        if (createOrNot == 'y' || createOrNot == 'Y') {
            createSavings(name, input);
        } else if (createOrNot == 'n' || createOrNot == 'N') {

        }
        // if answer not y or n
        else {
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
        try {
            System.out.print("What is your Checking Account current balance? ");
            balance = input.nextDouble();
        }catch(InputMismatchException ex) {
            System.out.println("Error: input must be an dollar value.");
            System.exit(0);
        }

            System.out.println("Error: input must be an integer.");
        // deposit more $$
        System.out.print("DO wish to make an deposit y/n? ");
        depositOrNot = input.next().charAt(0);
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            try {
                System.out.print("Enter amount wish to deposit");
                income = input.nextDouble();
                balance += income;
            }catch(InputMismatchException ex) {
                System.out.println("Error: input must be an dollar value.");
                System.exit(0);}

        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            income = 0;
        }else {
            System.out.println("input must be Y or N.");
            System.exit(0);
        }
        //user expenses
        System.out.print("Do you have any bills or expenses to pay Y/N ");
        depositOrNot = input.next().charAt(0);
        //number of user expenses
        if(depositOrNot == 'y' || depositOrNot =='Y') {
            System.out.print("Enter the number of different expenses ");
            numberOfExpenses = input.nextInt();
            //cost of each expense
            for(int i = 0; i < numberOfExpenses; i++){
                System.out.println("Enter expense amount: ");
                expenses.add(input.nextDouble());
            }
        }else if(depositOrNot == 'n' || depositOrNot =='N'){
            numberOfExpenses = 0;
        }else{
            System.out.println("input must be Y or N.");
            System.exit(0);
        }
        //write given info by the user to Accounts.txt
        try (java.io.PrintWriter myFile = new PrintWriter("Accounts.txt")) {
            myFile.printf(name + balance);
            //error writing to Accounts.txt file
        }catch (IOException e) {
            System.out.println("File cannot be opened");
            System.exit(0);
        }

        Checking.displayObject(new Checking(expenses,name,balance));

    }

    public static void createSavings(String name, Scanner input){
        //Creates a new savings account
        Savings userSavings = new Savings();

        //Asks for relevant Savings account information and the stores it.
        System.out.println("What is the name or names of the client that is starting the account?");
        userSavings.setName(input.next());
        System.out.println("What account number would you like to assign to this account?");
        userSavings.setAcctNum(input.nextInt());
        System.out.println("What is the beginning balance that you would like to add to this account?");
        userSavings.setBalance(input.nextDouble());
        System.out.println("What is the amount, if any, that will be contributed to this account monthly?");
        userSavings.setIncome(input.nextDouble());
        System.out.println("What is the current Annual Percentage Yield? Please use the decimal expression of the" +
                "percentage (ie .01 for 1%)");
        userSavings.setAnnualPercentageYield(input.nextDouble());

        //Creates a new file to write savings account data to.
        java.io.File file = new java.io.File("Accounts.txt");

        //Try catch statement that attempts to write to the created file.
        try {
            /*New PrintWriter object*/
            PrintWriter output = new PrintWriter(file);

            //Writes all relevant savings account data
            output.println(userSavings.getName());
            output.println(userSavings.getAcctNum());
            output.println(userSavings.getBalance());
            output.println(userSavings.getIncome());
            output.println(userSavings.getAnnualPercentageYield());

            /*Closes the output PrintWriter*/
            output.close();
        } catch (Exception ex) {
            /*Exception that throws an error if file cannot be found and closes the program.*/
            System.out.println("Unable to write to data file.");
            System.exit(-1);
        }

        //Try catch statement that attempts to read from the created file.
        try {
            /*New Scanner object using earlier created file*/
            Scanner fileRead = new Scanner(file);

            /*Output messages that shows all relevant Savings account data and calculates totals for the next 5 years.*/
            System.out.println("Client's name: " + fileRead.next());
            System.out.println("Account number: " + fileRead.nextInt());
            double startingBalance = fileRead.nextDouble();
            double monthlyContribution = fileRead.nextDouble();
            double apy = fileRead.nextDouble();
            double runningBalance = userSavings.calculateBalance(startingBalance, monthlyContribution, apy);
            System.out.printf("End of Year 1 balance: %4.2f \n", runningBalance);
            for(int i = 1; i < 5; i++){
                runningBalance += userSavings.calculateBalance(runningBalance, monthlyContribution, apy);
                System.out.printf("End of Year " + (i + 1) + " balance: %4.2f \n", runningBalance);
            }

            //Goodbye message
            System.out.println("Goodbye");

            /*Closes the file reading scanner and input scanner.*/
            fileRead.close();
            input.close();
        } catch (Exception ex) {
            /*Exception that throws an error if the file cannot be read or does not exits and closes the program.*/
            System.out.println("Unable to read data file.");
            System.exit(-1);
        }
    }
}


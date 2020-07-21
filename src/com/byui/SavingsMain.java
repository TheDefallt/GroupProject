package com.byui;

import java.io.PrintWriter;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class SavingsMain {
    public static void main(String[] args) {

        //Welcome message
        System.out.println("Would you like to create a Savings account? (y/n)");

        //Input Scanner with following boolean that stores user's decision to create a saving account
        Scanner input = new Scanner(System.in);
        String savingsProceed = input.next();

        //Switch case that moves user through the program and asks for savings account date if one is created.
        switch (savingsProceed){
            case "y":
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
                java.io.File file = new java.io.File("accounts.txt");

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
                break;
            case  "n":
                break;
            default:
                System.out.println("Incorrect response, please try again using the y or n keys");
                savingsProceed = input.next();
        }
    }
}

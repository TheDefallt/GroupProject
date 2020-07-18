package com.byui;

public class Main {
    /**
     *
     * @param args Program that collects and creates bank account information to help manage said created accounts
     */
    public static void main(String[] args) {
	//things needed
        //polymorphism
        //printWriter(write) check
        //file(read) check
        //Array or Arraylist check

        /**
         * Pesudo Code
         * tell the user what the program does
         * Prompt the user to INPUT full name
         *
         * Ask the user if they Want to start a checking
         *      IF user INPUT is yes
         *          * checking account info
         *               SCAN user input for Account Balance
         *               GENERATE account Number for user account
         *               Ask user if they have expenses
         *               IF yes Ask how many different expenses the user have
         *               DO Prompt user to enter expense amount and store it into expense  ARRAY
         *               WHILE CREATE file expenseData.txt
         *               CATCH ERROR file missing can not be created
         *               FOR each expense input WRITE it to expenseData.txt
         *               CATCH ERROR file cannot be opened
         *               then READ all the expense inputs in expenseData.txt
         *               CATCH ERROR reading the data
         *               WHILE finding the total amount of expenses
         *               SHOW name, account Number,starting balance,total expense, and current balance
         *
         *      ELSE IF user INPUT is no
         *          proceed to the rest of the program
         *      ElSE
         *         ERROR prompt user to enter yes no
         * Ask the user if they Want to start a checking
         *                IF user INPUT is yes
         *                    * savings account info
         *                         SCAN user input for Account Balance
         *                         GENERATE account Number for user account
         *                         SCAN user INPUT APR
         *                         Calculate the worth of savings account in an year
         *                         SHOW name, account Number,starting balance,APR, and projected balance
         *                ELSE IF user INPUT is no
         *                    proceed to the rest of the program
         *                ElSE
         *                   ERROR prompt user to enter yes no
         * SHOW accounts overview
         * SHOW goodbye message
         */
    }
}

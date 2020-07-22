package com.byui;

import java.util.Date;
import java.util.Random;

/**
 * UML
 *variables
 *      -acctNum: int
 *      -name: string
 *      -dateCreated: java.util.Date
 *      -Balance: double
 *      -income: double
 *Constructors
 *      +Account()
 *      +Account(name: string, acctnum: int, balance: double, income: double)
 *getters/setters
 *      +getAcctnum(): int
 *      +getName(): string
 *      +getDateCreated(): java.util.Date
 *      +getBalance(): double
 *      +getIncome(): double
 *      +setAcctnum(): void
 *      +setName(): void
 *      +setBalance(): void
 *      +setIncome(): void
 *
 *     +displayObject(Account object: object): String
 *
 */
public class Account {
    /**
     * Pseudo Code
     * CREATE Variables for Account Number, Users name, date of account creation or last updated, account balance, and users deposit
     * CREATE default object
     * CREATE object with parameters of user name and account balance
     *      SET accountNumber, user name, account balance, user deposit, and date account created or updated to object
     * SETTERS for accountNumber, user name, account balance, user deposit, and date account created or updated to Class
     * GETTERS for accountNumber, user name, account balance, user deposit, and date account created or updated to Class
     * OUTPUT account info to extension classes Savings and Checking
     */
    //variables
    private int acctNum;
    private String name;
    private java.util.Date dateCreated;
    private double balance, income;
    //default object
    public Account(){
        dateCreated = new java.util.Date();
    }
    //object
    public Account(String name, double balance){
        final int MAX= 999999999;
        Random rand= new Random();
        this.acctNum =rand.nextInt(MAX);
        this.name = name;
        dateCreated = new java.util.Date();
        this.balance = balance;
        this.income = income;

    }

    public double finalBalance(){
        return getBalance() + getIncome();
    }
    //getters and setters
    public int getAcctNum() {
        return acctNum;
    }
    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }

}

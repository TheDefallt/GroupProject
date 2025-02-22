package com.byui;

import java.util.ArrayList;

/**
 * UML
 *variables
 *      -monthlyExpenses: ArrayList<double>
 *Constructors
 *      +checking()
 *      +Checking(monthlyExpenses: double, name: string, balance: double)
 *getters/setters
 *      +getMonthlyExpenses(): ArrayList<double>
 *      +setMonthlyExpenses(): void
 *      +monthlyBalance(): double
 *
 *      toString: String
 */
public class Checking extends Account {
  /**
     * Pseudo Code
     * CREATE Variables for an Array list of doubles to store individual expenses 
     * CREATE default object
     * CREATE object with parameters of user name and account balance
     *      SET expenses, name, and balance
     * SETTERS for expenses
     * GETTERS for expenses
     * OUTPUT the total monthly balance of the checking account
     */
  //Holds a list of expenses to be figured into the user's budget.
  private ArrayList<Double> expenses = new ArrayList<>();

  //No-arg constructor
  public Checking(){
  }

  //Parameterized constructor
  public Checking(ArrayList<Double> expenses, String name, double balance){
    super(name, balance);
    this.expenses = expenses;
  }

  //Expense list getter
  public ArrayList<Double> getExpenses(){
    return expenses;
  }

  //Monthly Expense setter
  public void setExpenses(ArrayList<Double> expenses){
    this.expenses = expenses;
  }

  //Returns total of all expenses in the expenses ArrayList.
  public double getTotalExpenses(){
    double total = 0;
    for (double expense : expenses){
      total += expense;
    }
    return total;
  }

  //Returns total monthly balance after figuring income, current balance, and expenses
  public double finalBalance(){
    return super.getBalance() + super.getIncome() - getTotalExpenses();
  }
  //polymorpism display object output
  public static void displayObject(Checking object) {
    System.out.printf("%s\n%d\n%s\n%.2f\n%.2f\n%.2f\n%s\n%.2f",object.getName(), object.getAcctNum(), object.getDateCreated(), object.getBalance(),object.getIncome(),object.getTotalExpenses(),"---------------",object.finalBalance() );
  }
}

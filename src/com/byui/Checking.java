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

  //Monthly Expense list getter
  public ArrayList<Double> getMonthlyExpenses(){
    return expenses;
  }

  //Monthly Expense setter
  public void setMonthlyExpenses(ArrayList<Double> expenses){
    this.expenses = expenses;
  }

  //Returns total of all expenses in the monthlyExpenses ArrayList.
  public double totalMonthlyExpenses(){
    double total = 0;
    for (double expense : expenses){
      total += expense;
    }
    return total;
  }

  //Returns total monthly balance after figuring income, current balance, and expenses
  public double monthlyBalance(){
    return super.getBalance() + super.getIncome() - totalMonthlyExpenses();
  }
}

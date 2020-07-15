package com.byui;

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
public class checking extends account {
  //Holds a list of expenses to be figured into the user's budget.
  private ArrayList<double> expenses = new ArrayList<double>();
  
  //No-arg constructor
  public Checking(){
  }
  
  //Parameterized constructor
  public Checking(ArrayList<double> monthlyExpenses, string name, double balance){
      this.monthlyExpenses = monthlyExpenses;
      this.name = name;
      this.balance = balance;
  }
  
  //Monthly Expense list getter
  public ArrayList<double> getMonthlyExpenses(){
    return monthlyExpenses;
  }
  
  //Monthly Expense setter
  public void setMonthyExpenses(ArrayList<double> monthlyExpenses){
    this.monthlyExpenses = monthlyExpenses;
  }
  
  //Returns total of all expenses in the monthlyExpenses ArrayList.
  public double totalMonthlyExpenses(){
    double total = 0;
    for (double expense : monthlyExpenses){
      total += expense;
    }
    return total;
  }
  
  //Returns total monthly balance after figuring income, current balance, and expenses
  public double monthlyBalance(){
    return balance + income - totalMonthlyExpenses;
  }
}

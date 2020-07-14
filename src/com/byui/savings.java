package com.byui;

/**
 * UML
 *variables
 *      -annualInterestRate: double
 *Constructors
 *      +savings()
 *      +Savings(balance: double, name: string, annualInterestRate: double)
 *getters/setters
 *      +getAnnualInterestRate(): double
 *      +setAnnualInterestRate(): void
 *      +calculateAnnualBalance(): double
 *
 *      +toString: String
 *
 */
public class savings extends account {
  //Stores the APR for the savings account.
  private double annualPercentageYield;
  
  //No-arg constructor
  public Savings(){
  
  }
  
  //Parameterized constructor
  public Savings(double balance, string name, double annualPercentageYield){
    this.balance = balance;
    this.name = name;
    this.annualPercentageYield = annualPercentageYield;
  }
  
  //APR Getter
  public double getAnnualPercentageYield() {
    return annualPercentageYield;
  }
  
  //APR Setter
  public void setAnnualPercentageYield(double annualPercentageYield){
    this.annualPercentageYield = annualPercentageYield;
  }
  
  public double calculateAnnualBalance(){
    return 
  }
  
  
  
  
  
  
}

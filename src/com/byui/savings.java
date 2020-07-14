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
  private double annualPercentageYeild;
  
  //No-arg constructor
  public Savings(){
  
  }
  
  //Parameterized constructor
  public Savings(double balance, string name, double annualPercentageYeild){
    this.balance = balance;
    this.name = name;
    this.annualPercentageYeild = annualPercentageYeild;
  }
  
  //APR Getter
  public double getAnnualPercentageYeild() {
    return annualPercentageYeild;
  }
  
  //APR Setter
  public void setAnnualPercentageYeild(double annualPercentageYeild){
    this.annualPercentageYeild = annualPercentageYeild;
  }
  
  public double calculateAnnualBalance(){
    return 
  }
  
  
  
  
  
  
}

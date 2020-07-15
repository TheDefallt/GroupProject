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
public class Savings extends account {
  //Stores the APR for the savings account.
  private double annualPercentageYield;

  //No-arg constructor
  public Savings(){
  
  }
  
  //Parameterized constructor
  public Savings(double balance, String name, double annualPercentageYield){
    super(name, balance);
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
  
  //Returns the Annual Balance of the savings account
  public double calculateAnnualBalance(){
    return (account.balance * annualPercentageYield) + annualPercentageYield;
  }
}

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
public class Savings extends Account {
  /**
     * Pseudo Code
     * CREATE Variable for the Annual Percentage Yield
     * CREATE default object
     * CREATE object with parameters of balance, name, and Annual Percentage Yield
     *      SET balance, name, and Annual Percentage Yield
     * SETTERS for annualPercentageYield
     * GETTERS for annualPercentageYield
     * OUTPUT the total Annual Balance of the savings account with APY calculated in.
     */
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

  //APY Getter
  public double getAnnualPercentageYield() {
    return annualPercentageYield;
  }

  //APY Setter
  public void setAnnualPercentageYield(double annualPercentageYield){
    this.annualPercentageYield = annualPercentageYield;
  }

  //Returns the Annual Balance of the savings account
  public double calculateAnnualBalance(){
    return (super.getBalance() * annualPercentageYield) + annualPercentageYield;
  }
}

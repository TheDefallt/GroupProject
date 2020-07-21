package com.byui;

import java.util.Scanner;

public class SavingsMain {
    public static void main(String[] args) {

        System.out.println("Would you like to create a Savings account? (y/n)");

        Scanner input = new Scanner(System.in);
        String savingsProceed = input.next();

        switch (savingsProceed){
            case "y":

                break;
            case  "n":
                break;
            default:
                System.out.println("Please use the y or n keys to choose if you would like to create a savings account. (y/n)");
                savingsProceed = input.next();
        }

    }
    public void CreateSavings(){
        Savings userSavings = new Savings();

    }
}

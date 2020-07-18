package com.byui;

import java.util.ArrayList;
import java.util.Scanner;

public class Chewckingtest {
    

    public static void main(String[] args) {
        String name;
        char createOrNot;

        Scanner input= new Scanner(System.in);

       System.out.println(" Program info");
       System.out.print("Please enter you full name: ");
       name = input.nextLine();
       System.out.print(name + "Would you like to add an checking account Y/N?");
       createOrNot= input.next().charAt(0);
       if(createOrNot == 'y'|| createOrNot =='Y'){
           createChecking(name);
       }else{
           System.out.println("input must be Y or N.");
       }
    }
    public static void createChecking( String name){
        ArrayList<Double> expenses =new ArrayList<>();
        int  acctNum;
        double balance = 0, income;

        Account.displayObject(new Checking(expenses,name,balance));
    }

}

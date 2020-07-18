package com.byui;

import java.util.ArrayList;
import java.util.Scanner;

public class Chewckingtest {
    

    public static void main(String[] args) {
        String name;
        int  acctNum;
        double balance = 0, income;
        ArrayList<Double> expenses =new ArrayList<>();
        Scanner input= new Scanner(System.in);



       System.out.println(" Program info");
       System.out.print("Please enter you full name: ");
       name = input.nextLine();
        Account.displayObject(new Checking(name,balance));
    }


}

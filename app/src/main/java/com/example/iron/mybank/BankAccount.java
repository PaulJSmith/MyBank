package com.example.iron.mybank;

/**
 * Created by neon on 3/31/15.
 */
public class BankAccount {
    private double balance;
    public static final double overdraftFee = 30;

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;

    }

    public double getBalance(){
        return balance;
    }
}

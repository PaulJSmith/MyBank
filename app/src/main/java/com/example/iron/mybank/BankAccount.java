package com.example.iron.mybank;

import android.util.Log;

/**
 * Created by neon on 3/31/15.
 */
public class BankAccount {
    private double mBalance;
    public static final double OVERDRAFT_FEE = 30;

    public void withdraw(double amount){
        int x = 1;
        mBalance -= amount;
    }

    public void deposit(double amount){
        Log.d(TAG, x);
        mBalance += amount;

    }

    public double getBalance(){
        return mBalance;
    }
}

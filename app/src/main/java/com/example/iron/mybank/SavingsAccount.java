package com.example.iron.mybank;

import android.util.Log;

/**
 * Created by neon on 4/15/15.
 */
public class SavingsAccount extends BankAccount {
    private static final String TAG = "SavingsAccount";
    @Override
    public void withdraw(double amount) {
        if(numberOfWithdrawals() >= 3){
            return;
        }
        super.withdraw(amount);
    }
}

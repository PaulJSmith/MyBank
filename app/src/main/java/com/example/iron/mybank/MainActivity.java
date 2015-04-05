package com.example.iron.mybank;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    EditText mAmountInput;
    Button mWithdrawButton;
    Button mDepositButton;
    TextView mAmountDisplay;
    BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int [] arrayLiteral = {200,300,400,500,600};
        Log.d(TAG,"check it out " +arrayLiteral[4]);

        String [] stringArray = new String [2];
        stringArray[1] = "hello there";

        Log.d(TAG, stringArray[0]+" "+stringArray[1]);

        int[] array = new int[5];
        array[0] = 200;
        array[1] = 300;
        array[2] = 400;
        array[3] = 500;
        array[4] = 600;

        Log.d(TAG, "Position of array 0 is "+array[0]);

        mCurrentAccount = new BankAccount();
        mAmountInput = (EditText) findViewById(R.id.amount_input);
        mWithdrawButton = (Button) findViewById(R.id.button_withdraw);
        mDepositButton = (Button) findViewById(R.id.button_deposit);
        mAmountDisplay = (TextView) findViewById(R.id.balance_display);

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.withdraw(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());

            }
        });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.deposit(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

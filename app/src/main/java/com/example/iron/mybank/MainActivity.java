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

    EditText amountInput;
    Button withdrawButton;
    Button depositButton;
    TextView amountDisplay;
    BankAccount currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","Overdraft fee is "+ BankAccount.overdraftFee);

        currentAccount = new BankAccount();
        amountInput = (EditText) findViewById(R.id.amount_input);
        withdrawButton = (Button) findViewById(R.id.button_withdraw);
        depositButton = (Button) findViewById(R.id.button_deposit);
        amountDisplay = (TextView) findViewById(R.id.balance_display);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = amountInput.getText().toString();
                currentAccount.withdraw(Double.parseDouble(amount));
                amountDisplay.setText("Balance is "+currentAccount.getBalance());

            }
        });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = amountInput.getText().toString();
                currentAccount.deposit(Double.parseDouble(amount));
                amountDisplay.setText("Balance is "+currentAccount.getBalance());
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

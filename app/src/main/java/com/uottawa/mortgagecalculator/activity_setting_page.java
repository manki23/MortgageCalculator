package com.uottawa.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class activity_setting_page extends AppCompatActivity {

    /* Currency :
                    1 = Dollar
                    2 = Euro
                    3 = Pound
     */
    int     currency;

    /* paymentFrequency :
                    1 = Bi-Weekly
                    2 = Weekly
                    3 = Monthly
     */
    int     paymentFrequency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
    }

    public void dollarRadioBtn_onClick(View view) {
        currency = 1;
    }

    public void euroRadioBtn_onClick(View view) {
        currency = 2;
    }

    public void poundRadioBtn_onClick(View view) {
        currency = 3;
    }

    public void biWeeklyRadioBtn_onClick(View view) {
        paymentFrequency = 1;
    }

    public void weeklyRadioBtn_onClick(View view) {
        paymentFrequency = 2;
    }

    public void monthlyRadioBtn_onClick(View view) {
        paymentFrequency = 3;
    }

    public void saveOnClick(View view) {
        Intent gotoWelcome = new Intent(activity_setting_page.this, WelcomePageActivity.class);
        //gotoWelcome.putExtra() => return the choice made
        gotoWelcome.putExtra("currency", currency);
        gotoWelcome.putExtra("paymentFrequency", paymentFrequency);
        startActivity(gotoWelcome);
    }
}





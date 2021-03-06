package com.uottawa.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class WelcomePageActivity extends AppCompatActivity  {

    private EditText nameET;
    private EditText amountET;
    private EditText rateET;
    private EditText yearsET;

    private Double interest;
    private Double amount;
    private int nb_years;
    private String username;
    private int paymentmethod;
    private char currency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Intent intent = getIntent();

        if (savedInstanceState == null) {
            amount = 0.0;
            interest = 0.0;
            paymentmethod = 12;
            nb_years = 1;
            currency = '$';
        }

        if (intent != null){
            if (intent.hasExtra("currency")) {
                int c = intent.getIntExtra("currency", 0);
                if (c == 2) currency = '€';
                else if (c == 3) currency = '£';
            }

            if (intent.hasExtra("paymentFrequency")) {
                int c = intent.getIntExtra("paymentFrequency", 0);
                if (c == 1) paymentmethod = 24;
                else if (c == 2) paymentmethod = 52;
            }
        }

        nameET = (EditText) findViewById(R.id.name_id);
        amountET = (EditText) findViewById(R.id.amount_id);
        rateET = (EditText) findViewById(R.id.rate_id);
        yearsET = (EditText) findViewById(R.id.years_id);

    }



    public void calculBtn_onClick(View view) {

        username = nameET.getText().toString();
        nameET.setText(username);
        amount = Double.parseDouble(amountET.getText().toString());
        interest = Double.parseDouble(rateET.getText().toString()) / 100.00;
        nb_years = Integer.parseInt(yearsET.getText().toString());


        Double M, P, r;
        int n;
        String paymentmethodstring;

        if (paymentmethod == 12) paymentmethodstring = "monthly";
        else if (paymentmethod == 52) paymentmethodstring = "weekly";
        else paymentmethodstring = "Bi-Monthly";

        P = amount;
        r = interest / paymentmethod;
        n = paymentmethod * nb_years;


        M = P * (r * Math.pow((1 + r), n)) / (Math.pow(1 + r, n) - 1);
        Double result = (double) Math.round(M * 100) / 100;
        Intent gotoSummary = new Intent(WelcomePageActivity.this, SummaryPageActivity.class);
        gotoSummary.putExtra("text", username + " should make " + paymentmethodstring + " payments of " + currency + result);

        startActivity(gotoSummary);
    }

    public void detailsOnClick(View view) {
        Intent gotoDetails = new Intent(WelcomePageActivity.this, activity_details_page.class);
        startActivity(gotoDetails);
    }

    public void settingsOnClick(View view) {
        Intent gotoSettings = new Intent(WelcomePageActivity.this, activity_setting_page.class);
        startActivity(gotoSettings);
    }
}

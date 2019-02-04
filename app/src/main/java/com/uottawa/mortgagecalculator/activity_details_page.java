package com.uottawa.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_details_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
    }

    public void backOnClick(View view) {
        Intent gotoWelcome = new Intent(activity_details_page.this, WelcomePageActivity.class);
        startActivity(gotoWelcome);
    }
}

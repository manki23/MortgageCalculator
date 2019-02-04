package com.uottawa.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);

        String username = getIntent().getExtras().getString("name");

        TextView name1 = (TextView) findViewById(R.id.textViewName1);
        name1.setText(username);

    }


}

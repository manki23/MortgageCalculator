package com.uottawa.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);


        String text = getIntent().getExtras().getString("text");


        TextView display = (TextView) findViewById(R.id.summaryTextView);
        display.setText(text);

    }


}

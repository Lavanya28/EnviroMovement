package com.illinois.lavanyap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Resource_projectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //fetch all textviews representing numbers of resource saved
        final TextView metric_val = (TextView) findViewById(R.id.tv1);


        final TextView metric = (TextView) findViewById(R.id.title1);
        final TextView motivation = (TextView) findViewById(R.id.title2);








    }
}

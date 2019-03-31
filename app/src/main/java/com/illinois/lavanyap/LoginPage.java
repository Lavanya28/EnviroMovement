package com.illinois.lavanyap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class LoginPage extends Activity {

    //private static final android.R.attr R = ;
    private TextView logInTextView_AKA_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        logInTextView_AKA_button = (TextView) findViewById(R.id.logInTextView);

        logInTextView_AKA_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  startIntent = new Intent(getApplicationContext(), WhatAreYouSaving_NewSavingsProject_page1.class);
                startActivity(startIntent);
            }
        });

    }


}

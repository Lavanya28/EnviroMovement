package  com.illinois.lavanyap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class WhatAreYouSaving_NewSavingsProject_page1 extends Activity{

    private Button next_button_page1_newsavingsproject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_are_you_saving__new_savings_project_page1);

        next_button_page1_newsavingsproject = (Button) findViewById(R.id.NextButton_Page1_NewSavingsProject);
        next_button_page1_newsavingsproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MotivationDescription_NewSavingsProject_page2.class);
                startActivity(startIntent);
            }
        });
    }


}

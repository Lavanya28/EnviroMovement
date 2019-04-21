package com.illinois.lavanyap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resource_projectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Fetch all Increment buttons
        final Button b1 = (Button) findViewById(R.id.b1);
        final Button b2 = (Button) findViewById(R.id.b2);
        final Button b3 = (Button) findViewById(R.id.b3);
        final Button b4 = (Button) findViewById(R.id.b4);

        //fetch all textviews representing numbers of resource saved
        final TextView textview_one = (TextView) findViewById(R.id.tv1);
        final TextView textview_two = (TextView) findViewById(R.id.tv2);
        final TextView textview_three = (TextView) findViewById(R.id.tv3);
        final TextView textview_four = (TextView) findViewById(R.id.tv4);

         int desiredValue1 = 0;
         int desiredValue2 = 0;
         int desiredValue3 = 0;
         int desiredValue4 = 0;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView textview_one = (TextView) findViewById(R.id.tv1);
               String value1 = textview_one.getText().toString();
               int desiredValue1 = Integer.parseInt(value1);
              int newval1 = desiredValue1 + 1;
             textview_one.setText(newval1+"");


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView textview_one = (TextView) findViewById(R.id.tv2);
                String value2 = textview_one.getText().toString();
                int desiredValue2 = Integer.parseInt(value2);
                int newval2 = desiredValue2 + 1;
                textview_one.setText(newval2+"");


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView textview_one = (TextView) findViewById(R.id.tv3);
                String value1 = textview_one.getText().toString();
                int desiredValue1 = Integer.parseInt(value1);
                int newval1 = desiredValue1 + 1;
                textview_one.setText(newval1+"");


            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView textview_one = (TextView) findViewById(R.id.tv4);
                String value2 = textview_one.getText().toString();
                int desiredValue2 = Integer.parseInt(value2);
                int newval2 = desiredValue2 + 1;
                textview_one.setText(newval2+"");


            }
        });


        String value1 = textview_one.getText().toString();











        textview_one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            // on chnange what happens

            }
        });










    }
}

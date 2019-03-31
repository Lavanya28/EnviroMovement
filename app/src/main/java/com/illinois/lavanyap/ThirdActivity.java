package com.illinois.lavanyap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        TextView textview_one = (TextView) findViewById(R.id.tv1);
        String value1 = textview_one.getText().toString();
        int desiredValue1 = Integer.parseInt(value1);

        TextView textview_two = (TextView) findViewById(R.id.tv2);
        String value2 = textview_two.getText().toString();
        int desiredValue2 = Integer.parseInt(value2);

        int sum = desiredValue1 + desiredValue2;

        TextView total = (TextView) findViewById(R.id.total);



        total.setText(sum +"");


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
    }
}

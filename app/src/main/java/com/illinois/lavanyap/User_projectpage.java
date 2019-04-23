package com.illinois.lavanyap;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User_projectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle b = this.getIntent().getExtras();
        String projecttitle = b.getString("project");

        //fetch title of project

        final TextView title = (TextView) findViewById(R.id.title_user);

        title.setText(projecttitle);

        //fetch all textviews representing numbers of resource saved

        final TextView tot = (TextView) findViewById(R.id.total_user);

        final TextView metric = (TextView) findViewById(R.id.r_count);
        final TextView motivation = (TextView) findViewById(R.id.r_count2);


        final Button increment = (Button) findViewById(R.id.buttonuser);

        final SQLiteDatabase mydatabase4 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        Cursor cursor = mydatabase4.rawQuery("SELECT * from Project where ProjectName=" +"'"+ projecttitle+"'" ,null);

        cursor.moveToFirst();

        String motivation_text = cursor.getString(3);
        String metric_text = cursor.getString(4);
        String total_text = cursor.getString(6);



        metric.setText(metric_text);
        motivation.setText(motivation_text);
        tot.setText(total_text);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(tot.getText().toString());
                Integer new_count = count+1;
                tot.setText(new_count.toString());

            }
        });






    }
}


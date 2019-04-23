package com.illinois.lavanyap;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class User_projectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = this.getIntent().getExtras();
        String projecttitle = b.getString("project");

        //fetch title of project

        final TextView title = (TextView) findViewById(R.id.title);

        title.setText(projecttitle);

        //fetch all textviews representing numbers of resource saved

        final TextView tot = (TextView) findViewById(R.id.total);

        final TextView metric = (TextView) findViewById(R.id.contribution);
        final TextView motivation = (TextView) findViewById(R.id.title2);

        final SQLiteDatabase mydatabase4 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        Cursor cursor = mydatabase4.rawQuery("SELECT * from Project where ProjectName=" +"'"+ projecttitle+"'" ,null);

        cursor.moveToFirst();

        String motivation_text = cursor.getString(3);
        String metric_text = cursor.getString(4);
        String total_text = cursor.getString(6);



        metric.setText(metric_text);
        motivation.setText(motivation_text);
        tot.setText(total_text);








    }
}


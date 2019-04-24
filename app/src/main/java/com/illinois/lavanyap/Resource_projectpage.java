package com.illinois.lavanyap;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resource_projectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = this.getIntent().getExtras();
        final String projecttitle = b.getString("project");
        final String user = b.getString("username");
        //fetch title of project

        final TextView title = (TextView) findViewById(R.id.title);

        //Fetch button
        Button joinproject = (Button) findViewById(R.id.joinproject);

        title.setText(projecttitle);

        //fetch all textviews representing numbers of resource saved

        final TextView tot = (TextView) findViewById(R.id.total);

        final TextView metric = (TextView) findViewById(R.id.contribution);
        final TextView motiv = (TextView)findViewById(R.id.contribute);
        final TextView motivation = (TextView) findViewById(R.id.title2);

        final SQLiteDatabase mydatabase4 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        Cursor cursor = mydatabase4.rawQuery("SELECT * from Project where ProjectName=" +"'"+ projecttitle+"'" ,null);

        cursor.moveToFirst();

        String motivation_text = cursor.getString(3);
        String metric_text = cursor.getString(4);
        String total_text = cursor.getString(6);

        final String pid = cursor.getString(0);

        metric.setText(metric_text);
        motivation.setText(motivation_text);
        motiv.setText(motivation_text);
        tot.setText(total_text);

        joinproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Query2 = "INSERT INTO ProfileTable VALUES (" + "'"+ user + "'" + " ,"+ "'" + pid + "'" +  " , 0 ,0 )" ;
                mydatabase4.execSQL(Query2);


            }
        });







    }
}

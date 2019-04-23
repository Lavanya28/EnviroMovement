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
        final String projecttitle = b.getString("project");
        final String user = b.getString("username");
        //fetch title of project

        final TextView title = (TextView) findViewById(R.id.title_user);

        title.setText(projecttitle);

        //fetch all textviews representing numbers of resource saved

        final TextView tot = (TextView) findViewById(R.id.total_user);

        final TextView metric = (TextView) findViewById(R.id.r_count);
        final TextView motivation = (TextView) findViewById(R.id.r_count2);


        final Button increment = (Button) findViewById(R.id.buttonuser);

        final SQLiteDatabase mydatabase4 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        final Cursor cursor = mydatabase4.rawQuery("SELECT * from Project where ProjectName=" +"'"+ projecttitle+"'" ,null);

        cursor.moveToFirst();

        final String id = (cursor.getString(0));
        String motivation_text = cursor.getString(3);
        String metric_text = cursor.getString(4);

        Cursor cursor2 = mydatabase4.rawQuery("SELECT * from ProfileTable where Username=" + "'" + user + "'" + "and ProjectID=" + "'" + id+ "'"  , null);
        cursor2.moveToFirst();

        String total_text = cursor2.getString(3);



        metric.setText(metric_text);
        motivation.setText(motivation_text);
        tot.setText(total_text);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(tot.getText().toString());
                Integer new_count = count+1;
                tot.setText(new_count.toString());
                //update database both ProfileTable and Project here for user
                mydatabase4.execSQL("UPDATE ProfileTable SET Total =" + "'" + new_count.toString() + "'" + " WHERE Username=" + "'" + user + "'" + "AND ProjectID=" + "'" + id+ "'");
                Integer total = Integer.parseInt(cursor.getString(6));
                total = total + new_count;
                mydatabase4.execSQL("UPDATE Project SET Total =" + "'" + total.toString() + "'" + " WHERE ProjectName=" + "'" + projecttitle + "'" );

            }
        });






    }
}


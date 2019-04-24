package com.illinois.lavanyap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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



        //Bottom Nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView6);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(User_projectpage.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);

                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(User_projectpage.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(User_projectpage.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(User_projectpage.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.help:
                                        Toast.makeText(User_projectpage.this, "Help", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.action_settings:
                                        Toast.makeText(User_projectpage.this, "Settings", Toast.LENGTH_SHORT).show();
                                        Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(User_projectpage.this, "Info", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.logout:
                                        Intent loginintent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(loginintent);
                                        break;

                                }
                                return true;
                            }
                        });
                }

                return true;
            }
        });



    }
}


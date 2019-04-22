package com.illinois.lavanyap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class User_Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        final SQLiteDatabase mydatabase2 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        Button createproject = (Button) findViewById(R.id.createproject);

        TextView projectlist = (TextView) findViewById(R.id.projectlist);
        //Ecopoints
        //TextView ecopoints = (TextView) findViewById(R.id.ecopoints);
        //Total
        TextView total = (TextView) findViewById(R.id.totalsaved);
        //

        // Fetch List of Projects, Eco-points, total  corresponding to user from Profile table

        Bundle b = this.getIntent().getExtras();
        String user = "'"+b.getString("username")+"'";



         Cursor cursor = mydatabase2.rawQuery("SELECT * from ProfileTable where Username="+user  ,null);
         cursor.moveToFirst();

        //Fetch Eco points and total corresponding to User
        Integer user_total = 0;


        while (!cursor.isAfterLast()) {

            String val = cursor.getString(3);
            user_total = user_total + Integer.parseInt(val);

            cursor.moveToNext();


        }


        total.setText(user_total.toString());

        //Displaying project list
        Cursor cursor2 = mydatabase2.rawQuery("SELECT * from ProfileTable where Username="+user  ,null);
        cursor2.moveToFirst();

        List<String> listofprojects = new ArrayList<>();

        while (!cursor2.isAfterLast()) {

            String val = "'"+ cursor2.getString(1)+"'";

            Cursor c = mydatabase2.rawQuery("SELECT * from Project WHERE ProjectID = "+ val,null);
            c.moveToFirst();
            listofprojects.add(c.getString(1));


            cursor2.moveToNext();


        }

        String listString = "";

        for (String s : listofprojects)
        {
            listString += s + "\n";
        }

        projectlist.setText(listString);



        createproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(User_Profile.this.getApplicationContext(), Projectcreate_page1.class);
                //CHANGE THIS TO USER
                startIntent.putExtra("username", "Mary");
                User_Profile.this.startActivity(startIntent);


            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(User_Profile.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(User_Profile.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(User_Profile.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent  ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(User_Profile.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.help:
                                        Toast.makeText(User_Profile.this, "Help", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.action_settings:
                                        Toast.makeText(User_Profile.this, "Settings", Toast.LENGTH_SHORT).show();
                                        Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(User_Profile.this, "Info", Toast.LENGTH_SHORT).show();
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

                return false;
            }
        });









    }
}


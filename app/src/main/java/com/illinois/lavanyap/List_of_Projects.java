package com.illinois.lavanyap;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class List_of_Projects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_pro);

        final SQLiteDatabase mydatabase3 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        //set all buttons to invisible
        final Button p1 = (Button) findViewById(R.id.Project1);
        p1.setVisibility(View.GONE);

        final Button p2 = (Button) findViewById(R.id.Project2);
        p2.setVisibility(View.GONE);

        final Button p3 = (Button) findViewById(R.id.Project3);
        p3.setVisibility(View.GONE);

        final Button p4 = (Button) findViewById(R.id.Project4);
        p4.setVisibility(View.GONE);





        //fetch from add extras what type of resource it is
        Bundle b = this.getIntent().getExtras();
        String resource_type = b.getString("resource");


        if(resource_type.equals("plastic"))

        {
            //fetch all projects that are rtype plastic
            Cursor cursor = mydatabase3.rawQuery("SELECT * from Project where ResourceType= 'Plastics' "  ,null);
            cursor.moveToFirst();
            ArrayList<String> projects = new ArrayList<>();

            while (!cursor.isAfterLast()) {

                String val = cursor.getString(1);
                projects.add(val);

                cursor.moveToNext();


            }

            Integer size = projects.size();

            Integer c = 1;
            while (c <= size)
            {
                if(c==1){
                    p1.setText(projects.get(c-1));
                    p1.setVisibility(View.VISIBLE);

                }

                if(c==2){
                    p2.setText(projects.get(c-1));
                    p2.setVisibility(View.VISIBLE);
                }

                if(c==3){
                    p3.setText(projects.get(c-1));
                    p3.setVisibility(View.VISIBLE);
                }

                if(c==4){
                    p4.setText(projects.get(c-1));
                    p4.setVisibility(View.VISIBLE);
                }
              c=c+1;
            }





        }

        //Plastic ends here

        // Water resource type begins here

        if(resource_type.equals("water"))

        {
            //fetch all projects that are rtype plastic
            Cursor cursor = mydatabase3.rawQuery("SELECT * from Project where ResourceType= 'Water' "  ,null);
            cursor.moveToFirst();
            ArrayList<String> projects = new ArrayList<>();

            while (!cursor.isAfterLast()) {

                String val = cursor.getString(1);
                projects.add(val);

                cursor.moveToNext();


            }

            Integer size = projects.size();

            Integer c = 1;
            while (c <= size)
            {
                if(c==1){
                    p1.setText(projects.get(c-1));
                    p1.setVisibility(View.VISIBLE);
                }

                if(c==2){
                    p2.setText(projects.get(c-1));
                    p2.setVisibility(View.VISIBLE);
                }

                if(c==3){
                    p3.setText(projects.get(c-1));
                    p3.setVisibility(View.VISIBLE);
                }

                if(c==4){
                    p4.setText(projects.get(c-1));
                    p4.setVisibility(View.VISIBLE);
                }
                c=c+1;
            }





        }

        if(resource_type.equals("paper"))

        {
            //fetch all projects that are rtype plastic
            Cursor cursor = mydatabase3.rawQuery("SELECT * from Project where ResourceType= 'Paper' "  ,null);
            cursor.moveToFirst();
            ArrayList<String> projects = new ArrayList<>();

            while (!cursor.isAfterLast()) {

                String val = cursor.getString(1);
                projects.add(val);

                cursor.moveToNext();


            }
            Log.d("CREATE", projects.get(0));
            Integer size = projects.size();

            Integer c = 1;
            while (c <= size)
            {
                if(c==1){
                    p1.setText(projects.get(c-1));
                    p1.setVisibility(View.VISIBLE);
                }

                if(c==2){
                    p2.setText(projects.get(c-1));
                    p2.setVisibility(View.VISIBLE);
                }

                if(c==3){
                    p3.setText(projects.get(c-1));
                    p3.setVisibility(View.VISIBLE);
                }

                if(c==4){
                    p4.setText(projects.get(c-1));
                    p4.setVisibility(View.VISIBLE);
                }
                c=c+1;
            }





        }


        p1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(List_of_Projects.this.getApplicationContext(), Resource_projectpage.class);
                Intent project = startIntent.putExtra("project", p1.getText().toString());
                List_of_Projects.this.startActivity(startIntent);

            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(List_of_Projects.this.getApplicationContext(), Resource_projectpage.class);
                Intent project = startIntent.putExtra("project", p2.getText().toString());
                List_of_Projects.this.startActivity(startIntent);

            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(List_of_Projects.this.getApplicationContext(), Resource_projectpage.class);
                Intent project = startIntent.putExtra("project", p3.getText().toString());
                List_of_Projects.this.startActivity(startIntent);

            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(List_of_Projects.this.getApplicationContext(), Resource_projectpage.class);
                Intent project = startIntent.putExtra("project", p4.getText().toString());
                List_of_Projects.this.startActivity(startIntent);

            }
        });



        //onclick for ecotips make 4 pages corresponding to the resources



        BottomNavigationView bottomNavigation = (BottomNavigationView) findViewById(R.id.navigationView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(List_of_Projects.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(List_of_Projects.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(List_of_Projects.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent  ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(List_of_Projects.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.help:
                                        Toast.makeText(List_of_Projects.this, "Help", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.action_settings:
                                        Toast.makeText(List_of_Projects.this, "Settings", Toast.LENGTH_SHORT).show();
                                        Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(List_of_Projects.this, "Info", Toast.LENGTH_SHORT).show();
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

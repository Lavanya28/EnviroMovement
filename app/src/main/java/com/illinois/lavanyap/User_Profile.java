package com.illinois.lavanyap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;



import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;


import java.util.Random;

import java.util.ArrayList;
import java.util.List;


public class User_Profile extends AppCompatActivity {

    PieChart piechart;
    Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

           //Pie Chart
          piechart = (PieChart) findViewById(R.id.pieChart);
          piechart.getDescription().setEnabled(false);
          piechart.setRotationEnabled(true);
          addDataSet();


        //set all buttons to invisible
        final Button p1 = (Button) findViewById(R.id.up1);
        p1.setVisibility(View.GONE);

        final Button p2 = (Button) findViewById(R.id.up2);
        p2.setVisibility(View.GONE);

        final Button p3 = (Button) findViewById(R.id.up3);
        p3.setVisibility(View.GONE);

        final Button p4 = (Button) findViewById(R.id.up4);
        p4.setVisibility(View.GONE);


        final SQLiteDatabase mydatabase2 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        Button createproject = (Button) findViewById(R.id.createproject);

        //Ecopoints
        //TextView ecopoints = (TextView) findViewById(R.id.ecopoints);

        //Total
        TextView total = (TextView) findViewById(R.id.totalsaved);
        //

        // Fetch List of Projects, Eco-points, total  corresponding to user from Profile table

        Bundle b = this.getIntent().getExtras();
        final String User = b.getString("username");
        String user = "'"+b.getString("username")+"'";

        //Username Display
        TextView user_profile_name=(TextView) findViewById(R.id.username_profile);
        user_profile_name.setText("Hello " +User+"!");

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

        final List<String> listofprojects = new ArrayList<>();

        while (!cursor2.isAfterLast()) {

            String val = "'"+ cursor2.getString(1)+"'";

            Cursor c = mydatabase2.rawQuery("SELECT * from Project WHERE ProjectID = "+ val,null);
            c.moveToFirst();
            listofprojects.add(c.getString(1));


            cursor2.moveToNext();


        }


        Integer countofprojects = listofprojects.size();
        Log.d("CREATE",countofprojects.toString());

        Integer c = 1;

        while(c<=countofprojects){
            if(c==1){
                p1.setText(listofprojects.get(c-1));
                final Integer c_copy = c-1;
                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent loginintent = new Intent(getApplicationContext(), User_projectpage.class);
                        loginintent.putExtra("project", listofprojects.get(c_copy));
                        loginintent.putExtra("username", User);

                        startActivity(loginintent);


                    }
                });
                p1.setVisibility(View.VISIBLE);

            }

            if(c==2){
                p2.setText(listofprojects.get(c-1));
                final Integer c_copy = c-1;
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loginintent = new Intent(getApplicationContext(), User_projectpage.class);
                        loginintent.putExtra("project", listofprojects.get(c_copy));
                        loginintent.putExtra("username", User);

                        startActivity(loginintent);


                    }
                });
                p2.setVisibility(View.VISIBLE);
            }

            if(c==3){
                p3.setText(listofprojects.get(c-1));
                final Integer c_copy = c-1;
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loginintent = new Intent(getApplicationContext(), User_projectpage.class);
                        loginintent.putExtra("username", User);

                        loginintent.putExtra("project", listofprojects.get(c_copy));
                        startActivity(loginintent);


                    }
                });
                p3.setVisibility(View.VISIBLE);
            }

            if(c==4){
                p4.setText(listofprojects.get(c-1));
                final Integer c_copy = c-1;
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loginintent = new Intent(getApplicationContext(), User_projectpage.class);
                        loginintent.putExtra("username", User);
                        loginintent.putExtra("project", listofprojects.get(c_copy));
                        startActivity(loginintent);


                    }
                });
                p4.setVisibility(View.VISIBLE);
            }
            c=c+1;

        }



        createproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(User_Profile.this.getApplicationContext(), Projectcreate_page1.class);
                //CHANGE THIS TO USER
                startIntent.putExtra("username", User);
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
                        startIntent.putExtra("username", User);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(User_Profile.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        resintent.putExtra("username", User);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(User_Profile.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent  ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        ecotip.putExtra("username", User);
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
                                        settingintent.putExtra("username", User);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(User_Profile.this, "Info", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.logout:
                                        Intent loginintent = new Intent(getApplicationContext(), Login.class);
                                        loginintent.putExtra("username", User);
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

    private void addDataSet(){
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < 3  ; i++ )
        {
            yEntrys.add(new PieEntry(rand.nextInt(20)));

        }
        xEntrys.add("Take Your Car the Car Wash");
        xEntrys.add("Bring Your Own Mug");
        xEntrys.add("Carry Eco-Bag To Shop");

        PieDataSet pieDataSet = new PieDataSet(yEntrys,"");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(15);

        //add color to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(90,200,225));
        colors.add(Color.rgb(207,246,237));

        pieDataSet.setColors(colors);

        //add lengend to chart

        Legend legend = piechart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        piechart.setData(pieData);
        piechart.invalidate();

    }
}



package com.illinois.lavanyap;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Ecotip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecotip);
        //Links to outside articles

        TextView plasticlink = (TextView) findViewById(R.id.plastic_link);
        TextView waterlink = (TextView) findViewById(R.id.water_link);
        TextView misclink = (TextView) findViewById(R.id.misc_link);
        TextView paperlink = (TextView) findViewById(R.id.paper_link);
        plasticlink.setMovementMethod(LinkMovementMethod.getInstance());
        waterlink.setMovementMethod(LinkMovementMethod.getInstance());
        misclink.setMovementMethod(LinkMovementMethod.getInstance());
        paperlink.setMovementMethod(LinkMovementMethod.getInstance());



        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView6);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(Ecotip.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(Ecotip.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(Ecotip.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(Ecotip.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.help:
                                        Toast.makeText(Ecotip.this, "Help", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.action_settings:
                                        Toast.makeText(Ecotip.this, "Settings", Toast.LENGTH_SHORT).show();
                                        Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(Ecotip.this, "Info", Toast.LENGTH_SHORT).show();
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

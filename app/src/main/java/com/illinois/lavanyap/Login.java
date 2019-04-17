package com.illinois.lavanyap;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Login extends Activity {

    //private static final android.R.attr R = ;
    private TextView logInTextView_AKA_button;
    //Cursos resultSet = mydatabase.rawQuery("Select * from Login")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase mydatabase = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Login(UserName VARCHAR, Password VARCHAR);");
        mydatabase.execSQL("INSERT INTO Login VALUES('ADMIN','ADMIN');");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        logInTextView_AKA_button = (TextView) findViewById(R.id.Login_Buton);

        logInTextView_AKA_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  startIntent = new Intent(getApplicationContext(), User_Profile.class);
                startActivity(startIntent);
            }
        });



    }




}

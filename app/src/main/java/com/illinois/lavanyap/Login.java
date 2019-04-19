package com.illinois.lavanyap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity {

    //private static final android.R.attr R = ;
    private TextView logInTextView_AKA_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);




        logInTextView_AKA_button = (TextView) findViewById(R.id.Login_Buton);



        //SQLiteDatabase mydatabase = SQLiteDatabase.openDatabase("/data/data/" + "" + "/databases/" ,null);

        final SQLiteDatabase  mydatabase = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        String query = "CREATE TABLE IF NOT EXISTS UserTable (Username VARCHAR, Password VARCHAR)";

        mydatabase.execSQL(query);

        String insert = "INSERT OR IGNORE INTO UserTable(Username, Password) Values ('User1', 'Pass1')";
        mydatabase.execSQL(query);




        logInTextView_AKA_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor resultSet = mydatabase.rawQuery("Select * from UserTable",null);

                //fetch user inputs
                final EditText username = (EditText)findViewById(R.id.usernameLogin);
                final EditText password = (EditText) findViewById(R.id.passwordLogin);

                Intent  startIntent = new Intent(getApplicationContext(), User_Profile.class);
                startIntent.putExtra("username", "Mary");
                startActivity(startIntent);


                if (resultSet.moveToFirst()) {
                    while (!resultSet.isAfterLast()) {
                        String name = resultSet.getString(0);
                        String pass = resultSet.getString(1);

                        if(name.equals(username.getText().toString())  && pass.equals(password.getText().toString()))
                        {
                                Log.d("CREATION", password.toString());
//                                Intent  startIntent = new Intent(getApplicationContext(), User_Profile.class);
//                                startActivity(startIntent);
                                break;

                            }
                        resultSet.moveToNext();
                        }


                    }



            }
        });

    }


}

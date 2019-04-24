package com.illinois.lavanyap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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





        logInTextView_AKA_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //fetch user inputs
                final EditText username = (EditText)findViewById(R.id.usernameLogin);
                final EditText password = (EditText) findViewById(R.id.passwordLogin);

                String user = "'"+username.getText().toString()+ "'";
                final Intent  startIntent = new Intent(getApplicationContext(), User_Profile.class);

                Cursor resultSet = mydatabase.rawQuery("Select * from UserTable where Username ="+"'Mary'",null);

                //Log.d("CREATE","Inside");
                resultSet.moveToFirst();

                String pass = resultSet.getString(1);


                if(pass.equals(password.getText().toString()))
                {
                    startIntent.putExtra("username", username.getText().toString());
                    startActivity(startIntent);

                }




            }
        });

    }


}

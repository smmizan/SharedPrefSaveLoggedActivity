package com.smmizan.loginactivitysavesharedpreferanceapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userID,userPassword;
    Button bLogin;


    SharedPreferencesConfig sharedPreferencesConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferencesConfig = new SharedPreferencesConfig(getApplicationContext());



        userID = (EditText) findViewById(R.id.etUserID);
        userPassword = (EditText) findViewById(R.id.etUserPassword);


        bLogin = (Button) findViewById(R.id.buttonLogin);


        if(sharedPreferencesConfig.readLoginStatus())
        {
            Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
            startActivity(intent);
            finish();
        }

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();
                String pass = userPassword.getText().toString();

                if(id.equals(getResources().getString(R.string.user_id)) && pass.equals(getResources().getString(R.string.user_pass)))
                {

                    Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    sharedPreferencesConfig.writeLoginStatus(true);
                    finish();

                }else
                {
                    Toast.makeText(MainActivity.this, "Invalid User or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

package com.example.root.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 2/3/19.
 */

public class SessionDemo extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    EditText e1,e2;
    String uname,pass;
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        sharedPreference= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreference.edit();
        b1=findViewById(R.id.shbutton1);
        b1.setOnClickListener(this);

        boolean value=sharedPreference.getBoolean("Login",false);
        if(value==true)
        {
            Intent intent=new Intent(SessionDemo.this,FirstPage.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {

        editor.putBoolean("Login",true);
        editor.commit();

        Intent intent=new Intent(SessionDemo.this,FirstPage.class);
        startActivity(intent);


    }
}

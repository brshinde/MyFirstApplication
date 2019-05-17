package com.example.root.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 24/2/19.
 */

public class SharedPreference extends AppCompatActivity
{


    Button b1;
    EditText e1,e2;
    String uname,pass;
    SharedPreferences sharedPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        sharedPreference= PreferenceManager.getDefaultSharedPreferences(this);
        b1=findViewById(R.id.shbutton1);
        e1=findViewById(R.id.shedt1);
        e2=findViewById(R.id.shedt2);

        Boolean register = sharedPreference.getBoolean("Login",false);

        if(register)
        {
            Intent intent=new Intent(SharedPreference.this,FirstPage.class);
            startActivity(intent);

        }

      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              uname=e1.getText().toString();
              pass=e2.getText().toString();
              SharedPreferences.Editor editor = sharedPreference.edit();

              editor.putString("Name", uname);
              editor.putString("Password",pass);
              editor.putBoolean("Login",true);
              editor.commit();

              Intent intent=new Intent(SharedPreference.this,FirstPage.class);
              startActivity(intent);

          }
      });
    }

}

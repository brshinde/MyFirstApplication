package com.example.root.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by root on 2/3/19.
 */

public class TempData extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2;
    Button b1;
    CheckBox c1;
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        b1=findViewById(R.id.shbutton1);
        e1=findViewById(R.id.shedt1);
        e2=findViewById(R.id.shedt2);
        c1=findViewById(R.id.upc);
        sharedPreference=PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreference.edit();
        b1.setOnClickListener(this);
        e1.setText(sharedPreference.getString("Uname",""));
        e2.setText(sharedPreference.getString("Upass",""));

    }

    @Override
    public void onClick(View v)
    {

        if(c1.isChecked()==true)
        {
            editor.putString("Uname",e1.getText().toString());
            editor.putString("Upass",e2.getText().toString());
            editor.commit();


        }
    }
}

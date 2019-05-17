package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 18/1/19.
 */

public class Home extends AppCompatActivity implements View.OnClickListener {


    EditText e1,e2;
    TextView t1,t2;
    Button b1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        e1=findViewById(R.id.edt_username);
        e2=findViewById(R.id.edt_password);
        t1=findViewById(R.id.txt_username);
        t2=findViewById(R.id.txt_password);
        b1=findViewById(R.id.button1);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       String uname= e1.getText().toString();
       String password=e2.getText().toString();

       t1.setText(uname);
       t2.setText(password);

    }
}

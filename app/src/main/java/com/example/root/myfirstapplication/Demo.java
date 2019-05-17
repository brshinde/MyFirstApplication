package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 9/2/19.
 */

public class Demo extends AppCompatActivity implements View.OnClickListener {

  EditText e1,e2;
  TextView t1,t2;
  Button b1,b2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        e1=findViewById(R.id.edt1);
        e2=findViewById(R.id.edt2);
        b1=findViewById(R.id.log);
        t1=findViewById(R.id.txt1);
        t2=findViewById(R.id.txt2);
        b2=findViewById(R.id.log2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.log)
        {

            String uname = e1.getText().toString();
            String pass = e2.getText().toString();

            t1.setText(uname);
            t2.setText(pass);

        }

        if(v.getId()==R.id.log2) {



            t1.setText("button 2 pressed");
            t2.setText("button 2 ");
        }

    }
}

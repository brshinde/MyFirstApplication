package com.example.root.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 27/1/19.
 */

public class PassingData extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    EditText name,address;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passinglayout);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        b1=findViewById(R.id.passing_btn);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        Intent intent=new Intent(PassingData.this,RecivingData.class);
        intent.putExtra("Message1",name.getText().toString());
        intent.putExtra("Message2",address.getText().toString());
        startActivity(intent);


    }
}

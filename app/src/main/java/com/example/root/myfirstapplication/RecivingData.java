package com.example.root.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by root on 27/1/19.
 */

public class RecivingData extends AppCompatActivity {

    EditText e1,e2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recivelayout);
        Intent i = getIntent();
        String message1 = i.getStringExtra("Message1");
        String message2 = i.getStringExtra("Message2");
        e1=findViewById(R.id.name_recive);
        e2=findViewById(R.id.address_recive);
        e1.setText(message1);
        e2.setText(message2);
    }
}

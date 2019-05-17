package com.example.root.myfirstapplication;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 18/1/19.
 */

public class Addition extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3;
    Button b1,b2;
    BroadCast broadCast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        e1=findViewById(R.id.num1);
        e2=findViewById(R.id.num2);
        e3=findViewById(R.id.result);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.sub);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        broadCast=new BroadCast();

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Addition.this,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    1);
        }

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        Log.i("Message","You are in onStart - Activity1");
        registerReceiver(broadCast,intentFilter);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.add)
        {

   /* String s1=e1.getText().toString();
    String s2=e2.getText().toString();
    int a=Integer.parseInt(s1);
    int b=Integer.parseInt(s2);
    int c = a+b;
    String s3 = String.valueOf(c);
    e3.setText(s3);*/

            Intent intent = new Intent();
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setAction("a.b.c");
            sendBroadcast(intent);

    }
    else
        {
            String s1=e1.getText().toString();
            String s2=e2.getText().toString();
            int a=Integer.parseInt(s1);
            int b=Integer.parseInt(s2);
            int c = a-b;
            String s3 = String.valueOf(c);
            e3.setText(s3);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCast);
    }
}

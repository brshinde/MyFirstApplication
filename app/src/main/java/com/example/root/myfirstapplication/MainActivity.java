package com.example.root.myfirstapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   Button b1;
   EditText e1,e2,e3;
   int c;
   CheckBox c1;
   BroadCast broadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Message","You are in onCreate - Activity1");
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
        e3=findViewById(R.id.add);
        b1=findViewById(R.id.submit);
        b1.setOnClickListener(this);
        broadCast=new BroadCast();

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
    protected void onResume() {
        super.onResume();
        Log.i("Message","You are in onResume - Activity1");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Message","You are in onPause - Activity1");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Message","You are in onStop - Activity1");
        unregisterReceiver(broadCast);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Message","You are in onRestart - Activity1");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Message","You are in onDestroy - Activity1");

    }

    @Override
    public void onClick(View v) {
        /*String uname=e1.getText().toString();
        String password=e2.getText().toString();
        c=Integer.parseInt(uname)+Integer.parseInt(password);
        e3.setText(String.valueOf(c));*/
        Intent intent=new Intent(MainActivity.this,Registration.class);
        startActivity(intent);

    }

}

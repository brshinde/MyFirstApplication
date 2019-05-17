package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by root on 18/1/19.
 */

public class Registration extends AppCompatActivity {
   ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);
        Log.i("Message","You are in onCreate - Activity2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Message","You are in onStart - Activity2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Message","You are in onResume - Activity2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Message","You are in onPause - Activity2");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.i("Message","You are in onStop - Activity2");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.i("Message","You are in onRestart - Activity2");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("Message","You are in onDestroy - Activity2");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

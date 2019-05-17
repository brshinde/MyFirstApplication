package com.example.root.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 24/2/19.
 */

public class FirstPage extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    Button b1;
    SharedPreferences sharedPreference;
    TextView textView;
    SeekBar seekBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        b1=findViewById(R.id.hombutton);
        seekBar=findViewById(R.id.skbar);
        textView=findViewById(R.id.status);
        sharedPreference= PreferenceManager.getDefaultSharedPreferences(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putBoolean("Login",false);
                editor.commit();

                Intent intent=new Intent(FirstPage.this,SessionDemo.class);
                startActivity(intent);
            }
        });

        textView.setText("Covered :" + seekBar.getProgress() + "/" +seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



        textView.setText("Covered :" + progress + "/" +seekBar.getMax());


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        Toast.makeText(this,String.valueOf(seekBar.getProgress()),Toast.LENGTH_SHORT).show();

    }
}

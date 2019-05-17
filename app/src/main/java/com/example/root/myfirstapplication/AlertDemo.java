package com.example.root.myfirstapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 3/3/19.
 */

public class AlertDemo extends AppCompatActivity {

    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        builder=new AlertDialog.Builder(this);
        b1=findViewById(R.id.shbutton1);
        builder.setMessage("Do you want Download Image").setTitle("Downloading");
        builder.setCancelable(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(),"Downloading",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog=builder.create();
                alertDialog.show();
            }
        });

    }
}

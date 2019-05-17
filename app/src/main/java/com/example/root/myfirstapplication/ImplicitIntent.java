package com.example.root.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 27/1/19.
 */

public class ImplicitIntent extends AppCompatActivity implements View.OnClickListener
{
    Button b1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.javatpoint.com"));
        startActivity(intent);

    }

}

package com.example.root.myfirstapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 2/3/19.
 */

public class ProgressD extends AppCompatActivity implements View.OnClickListener {

   ProgressDialog progressDialog;
   Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progresslayout);
        progressDialog=new ProgressDialog(this);
        b1=findViewById(R.id.dowloadbtn);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        progressDialog.setMessage("Downloading Music");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();
        for(int i=0;i<=100;i++)
        {
            progressDialog.setProgress(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}

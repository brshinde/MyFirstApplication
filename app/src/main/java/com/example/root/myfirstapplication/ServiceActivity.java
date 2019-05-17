package com.example.root.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 22/3/19.
 */

public class ServiceActivity extends AppCompatActivity {

    Button starts,stops;
    int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        starts=findViewById(R.id.startservice);
        stops=findViewById(R.id.stopservice);

        starts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(ServiceActivity.this,ServiceClass.class);
                startService(intent);*/

                startService(new Intent(ServiceActivity.this, ServiceClass.class));

            }
        });

        stops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent=new Intent(ServiceActivity.this,ServiceClass.class);
                stopService(intent);


            }
        });

    }
}

package com.example.root.myfirstapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 23/3/19.
 */

public class NotificationDemo extends AppCompatActivity {

      Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationlayout);
        b1=findViewById(R.id.getloc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NotificationDemo.this, NotificationDemo.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDemo.this,0,intent,0);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.img3)
                                .setContentTitle("Notification Title")
                                .setContentText("Notification ")
                                .setContentIntent(pendingIntent );

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mBuilder.build());
            }
        });
    }
}

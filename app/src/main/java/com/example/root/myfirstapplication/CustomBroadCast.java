package com.example.root.myfirstapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by root on 23/2/19.
 */

public class CustomBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Custom Broadcast Triggered",Toast.LENGTH_SHORT).show();
    }
}

package com.example.root.myfirstapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by root on 16/2/19.
 */

public class BroadCast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Sms Recived",Toast.LENGTH_SHORT).show();
    }
}

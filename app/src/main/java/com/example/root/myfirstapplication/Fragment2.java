package com.example.root.myfirstapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 23/3/19.
 */

public class Fragment2 extends Fragment {

   /* public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState){
        return inflater.inflate(R.layout.back2, vg,false);

    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.back2, container,false);
    }
}


package com.example.root.myfirstapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by root on 23/3/19.
 */

public class FragmentClass extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState){
        return inflater.inflate(R.layout.back1, vg,false);

    }
}

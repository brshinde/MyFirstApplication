package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 27/1/19.
 */

public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        sp=findViewById(R.id.sp);

        List<String> categories=new ArrayList<>();
        categories.add("solapur");
        categories.add("pune");
        categories.add("nagpur");
        categories.add("nashik");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        sp.setAdapter(arrayAdapter);

        sp.setOnItemSelectedListener(this);
}




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        String item = parent.getSelectedItem().toString();
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}

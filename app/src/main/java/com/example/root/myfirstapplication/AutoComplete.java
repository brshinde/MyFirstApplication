package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * Created by root on 1/3/19.
 */

public class AutoComplete extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    AutoCompleteTextView autoComplete;
    String[] ar={"java","hadoop","linux","android","testing"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletelayout);
        autoComplete=findViewById(R.id.auto);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.select_dialog_item,ar);
        autoComplete.setAdapter(arrayAdapter);
        autoComplete.setThreshold(1);
        autoComplete.setOnItemSelectedListener(this);
       /* autoComplete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

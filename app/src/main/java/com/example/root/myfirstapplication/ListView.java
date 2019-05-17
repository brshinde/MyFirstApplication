package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by root on 1/3/19.
 */

public class ListView extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] s={"solapur","pune","nashik","nagpur","mumbai","kolhapur","amravati","nagar"};
    android.widget.ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);
        listView=findViewById(R.id.listv);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String s=parent.getItemAtPosition(position).toString();
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

    }
}

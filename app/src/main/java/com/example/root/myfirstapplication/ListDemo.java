package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

/**
 * Created by root on 3/3/19.
 */

public class ListDemo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] s={"android","java","hadoop","linux","aws"};
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);
        listView=findViewById(R.id.listv);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();

    }
}

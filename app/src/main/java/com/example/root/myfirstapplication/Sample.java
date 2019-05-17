package com.example.root.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by root on 18/1/19.
 */

public class Sample extends AppCompatActivity implements View.OnClickListener {


    ImageView i1;
    Button b1;
    CheckBox c1,c2,c3,c4;
    RadioButton radioButton;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        i1=findViewById(R.id.img);
        b1=findViewById(R.id.btn);
        i1.setOnClickListener(this);
        b1.setOnClickListener(this);
        c1=findViewById(R.id.chkbox1);
        c2=findViewById(R.id.chkbox2);
        c3=findViewById(R.id.chkbox3);
        c4=findViewById(R.id.chkbox4);
        radioGroup=findViewById(R.id.rgroup);

    }

    @Override
    public void onClick(View v)
    {

        StringBuilder sb=new StringBuilder();

    /*    if(v.getId()==R.id.img)
        {
            Intent intent = new Intent(Sample.this, Addition.class);
            startActivity(intent);
        }
        else
        {
            Intent int1 = new Intent(Sample.this, Home.class);
            startActivity(int1);
        }*/


        if(c1.isChecked()==true)
        {
            sb.append(c1.getText().toString()+" city checked");

        }

        if(c2.isChecked()==true)
        {
            sb.append(c2.getText().toString()+"city checked");

        }


        if(c3.isChecked()==true)
        {
            sb.append(c3.getText().toString()+"city checked");

        }

        if(c4.isChecked()==true)
        {
            sb.append(c4.getText().toString()+"city checked");

        }

       /* if(rb1.isChecked())
        {
            Toast.makeText(this,rb1.getText(),Toast.LENGTH_SHORT).show();

        }


        if(rb2.isChecked())
        {
            Toast.makeText(this,rb2.getText(),Toast.LENGTH_SHORT).show();

        }*/

       /* int id=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(id);

        Toast.makeText(this,radioButton.getText(),Toast.LENGTH_SHORT).show();*/


        Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();

    }
}

package com.example.root.myfirstapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by root on 3/3/19.
 */

public class DandTdemo extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2;
    Calendar c;
    int y,m,d;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetimelayout);
        e1=findViewById(R.id.date);
        e2=findViewById(R.id.time);
        e1.setOnClickListener(this);
        e2.setOnClickListener(this);
        c=Calendar.getInstance();
        y=c.get(Calendar.YEAR);
        m=c.get(Calendar.MONTH);
        d=c.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.date)
        {

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    month=month+1;
                    e1.setText(dayOfMonth+"/"+month+"/"+year);

                }
            },y,m,d);
            datePickerDialog.show();

        }

        if(v.getId()==R.id.time)
        {
            int h,m;
            h=c.get(Calendar.HOUR_OF_DAY);
            m=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    e2.setText(hourOfDay+":"+minute);

                }
            },h,m,false);
            timePickerDialog.show();
        }
    }
}

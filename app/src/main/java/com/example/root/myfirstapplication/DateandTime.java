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
import java.util.TimeZone;

/**
 * Created by root on 3/3/19.
 */

public class DateandTime extends AppCompatActivity implements View.OnClickListener {


    EditText e1,e2;
    int d,m,y;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetimelayout);
        e1=findViewById(R.id.date);
        e2=findViewById(R.id.time);
       e1.setOnClickListener(this);
       e2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.date)
        {
            Calendar c=Calendar.getInstance();
            d=c.get(Calendar.DAY_OF_MONTH);
            m=c.get(Calendar.MONTH);
            y=c.get(Calendar.YEAR);


           /* DatePickerDialog dialog =
                    new DatePickerDialog(this, mDateSetListener, y, m, d);
            dialog.show();*/
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    month=month+1;

                    e1.setText(dayOfMonth+"/"+month+"/"+year);                }
            },y,m,d);
            datePickerDialog.show();


        }
        if(v.getId()==R.id.time)
        {
            Calendar c=Calendar.getInstance(TimeZone.getDefault());
            int h=c.get(Calendar.HOUR_OF_DAY);
            int m=c.get(Calendar.MINUTE);

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

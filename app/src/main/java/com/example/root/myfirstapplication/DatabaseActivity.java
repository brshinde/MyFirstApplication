package com.example.root.myfirstapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 9/3/19.
 */

public class DatabaseActivity extends AppCompatActivity {

    EditText name,sname,mark,id;
    String nam,surname;
    int marks;
    Button add,view,update,delete;
    DbTutorial dbTutorial;
    TextView displaydata;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dblayout);
        name=findViewById(R.id.name);
        sname=findViewById(R.id.surname);
        mark=findViewById(R.id.marks);
        id=findViewById(R.id.id);
        add=findViewById(R.id.add);
        view=findViewById(R.id.view);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        displaydata=findViewById(R.id.displaydata);
        dbTutorial=new DbTutorial(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                boolean isInserted = dbTutorial.insertData(Integer.parseInt(id.getText().toString()),name.getText().toString(),sname.getText().toString(),Integer.parseInt(mark.getText().toString()));
                if(isInserted == true)
                    Toast.makeText(DatabaseActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = dbTutorial.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    Toast.makeText(DatabaseActivity.this,"Data not Available",Toast.LENGTH_LONG).show();

                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getInt(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Marks :"+ res.getInt(3)+"\n\n");
                }

              displaydata.setText(buffer.toString());

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                boolean isUpdate = dbTutorial.updateData(Integer.parseInt(id.getText().toString()),
                        name.getText().toString(),sname.getText().toString(),Integer.parseInt(mark.getText().toString()));
                if(isUpdate == true)
                    Toast.makeText(DatabaseActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deletedRows = dbTutorial.deleteData(Integer.parseInt(id.getText().toString()));
                if(deletedRows > 0)
                    Toast.makeText(DatabaseActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });



    }
}

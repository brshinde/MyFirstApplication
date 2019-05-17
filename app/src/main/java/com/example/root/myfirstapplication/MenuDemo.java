package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by root on 23/2/19.
 */

public class MenuDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item1:

                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:

                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.item3:

                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:

                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                break;

            case R.id.subitem1:

                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                break;
            default:

              //  return super.onOptionsItemSelected(item);

        }

        return true;
    }


}

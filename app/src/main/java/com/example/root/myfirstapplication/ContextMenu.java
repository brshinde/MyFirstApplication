package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 23/2/19.
 */

public class ContextMenu extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_layou);
        button=findViewById(R.id.context_button);
        registerForContextMenu(button);

    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
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

            default:


        }

        return super.onContextItemSelected(item);
    }
}

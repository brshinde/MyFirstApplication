package com.example.root.myfirstapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by root on 27/1/19.
 */

public class CameraRequest extends AppCompatActivity implements View.OnClickListener {

    int Camera_Request = 1888;
    int Abc=2555;
    ImageView imageView,imgview2;
    Button click,b2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        click=findViewById(R.id.camera_button);
        imageView = findViewById(R.id.camera_imgview);
        imgview2=findViewById(R.id.camera_imgview2);
        b2=findViewById(R.id.button2);
        click.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Camera_Request) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }

        if (requestCode == Abc) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgview2.setImageBitmap(photo);

        }



     }

    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.camera_button)
        {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, Camera_Request);
        }

        if(v.getId()==R.id.button2)
        {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, Camera_Request);
        }

    }

}
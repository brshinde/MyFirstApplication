package com.example.root.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 22/3/19.
 */

public class ContentProvider extends AppCompatActivity {

    Button b1;
    private final int abc = 1;
    String NUMBER;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentlayout);
        b1=findViewById(R.id.readcontact);
        NUMBER=ContactsContract.CommonDataKinds.Phone.NUMBER;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,abc);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==abc)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                /*Uri contactdata= data.getData();
                Cursor c=getContentResolver().query(contactdata,null,null,null,null);
                if(c.moveToFirst())
                {
                    String name=c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                    String number=c.getString(c.getColumnIndex(NUMBER));

                    Toast.makeText(this,number,Toast.LENGTH_SHORT).show();
                }*/


                Uri contactData = data.getData();

                Cursor cur =  getContentResolver().query(contactData, null, null, null, null);
                if (cur.getCount() > 0) {// thats mean some resutl has been found
                    if(cur.moveToNext()) {
                        String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                        if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                        {

                            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id,null, null);
                            while (phones.moveToNext()) {
                                String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
                            }
                            phones.close();
                        }

                    }
                }
                cur.close();


                
            }
        }
    }
}

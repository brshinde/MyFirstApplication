package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by root on 16/5/19.
 */

public class WebService extends AppCompatActivity {

    private static final String JSON_URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";

    TextView textView;
    Button subdata;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webservicelayout);

       // textView=findViewById(R.id.displaytext);
        subdata=findViewById(R.id.submit_data);
        subdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loaddata();



            }
        });
    }

    private void loaddata()
    {
        final ArrayList<String> arrayList=new ArrayList<String >();

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("heroes");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject data=jsonArray.getJSONObject(i);
                        String name= data.optString("name");
                        String imgurl=data.optString("imageurl");
                        arrayList.add(name);
                        arrayList.add(imgurl);
                    }

                    textView.setText(arrayList.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);

    }
}

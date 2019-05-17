package com.example.root.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16/5/19.
 */

public class VolleyTutorial extends AppCompatActivity {

   TextView textView;
   Button button;
   List<ModelClass> list;
   android.widget.ListView listView;
    ListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webservicelayout);
       // textView=findViewById(R.id.displaytext);
        button=findViewById(R.id.submit_data);
        listView=findViewById(R.id.listView);
        list=new ArrayList<>();
        adapter = new ListAdapter(list, getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaddata();
            }
        });

       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               adapter.remove(list.get(position));
               adapter.notifyDataSetChanged();
               return true;
           }
       });
    }

    private void loaddata()
    {
        String json_url="https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        final ArrayList<String>arrayList=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, json_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);

                    JSONArray jsonArray=jsonObject.getJSONArray("heroes");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject obj=jsonArray.getJSONObject(i);
                        String name=obj.optString("name");
                        String img=obj.optString("imageurl");

                        ModelClass modelClass=new ModelClass(name,img);
                        list.add(modelClass);




                        //adding the adapter to listview
                        listView.setAdapter(adapter);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

               // textView.setText(arrayList.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}

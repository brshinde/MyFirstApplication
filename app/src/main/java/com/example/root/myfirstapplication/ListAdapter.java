package com.example.root.myfirstapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by root on 16/5/19.
 */

public class ListAdapter extends ArrayAdapter<ModelClass> {

    List<ModelClass> list;
    Context context;

    ListAdapter(List<ModelClass> list,Context context)
    {
        super(context, R.layout.list_item, list);
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        ImageView imageView=listViewItem.findViewById(R.id.imgview);


       ModelClass modelClass=list.get(position);
        textViewName.setText(modelClass.getName());
        textViewImageUrl.setText(modelClass.getImageurl());

        Glide.with(context).load(modelClass.getImageurl()).into(imageView);


        //returning the listitem
        return listViewItem;
    }
}

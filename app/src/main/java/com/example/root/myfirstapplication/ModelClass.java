package com.example.root.myfirstapplication;

/**
 * Created by root on 16/5/19.
 */

public class ModelClass {


    String name,imageurl;

    public ModelClass(String name,String imageurl)
    {
        this.name=name;
        this.imageurl=imageurl;
    }

    public String getName()
    {
        return name;
    }

    public String getImageurl()
    {
        return imageurl;
    }
}

package com.example.root.myfirstapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 9/3/19.
 */

public class DbTutorial extends SQLiteOpenHelper {

    private static final String name="mydb";
    public static final String TABLE_NAME = "STUDENT";
    private static final int version=1;

    public DbTutorial(Context context)
    {
        super(context,name,null,version);

    }


    @Override

    public void onCreate(SQLiteDatabase db)
    {
       String sql="CREATE TABLE STUDENT(ID INTEGER PRIMARY KEY,NAME TEXT,SURNAME TEXT,MARKS INT)";
       db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(int id,String name,String surname,int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("SURNAME",surname);
        contentValues.put("MARKS",marks);
        contentValues.put("ID",id);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(int id,String name,String surname,int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("SURNAME",surname);
        contentValues.put("MARKS",marks);
        db.update(TABLE_NAME, contentValues, "ID="+id,null);
        return true;
    }

    public Integer deleteData (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {String.valueOf(id)});
    }
}

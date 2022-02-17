package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {

    static String DbName="company.db";
    static String TableName="Product";
    static String col1="id";
    static String col2="code";
    static String col3="name";
    static String col4="price";

    public DatabaseHelper( Context context) {
        super(context, DbName, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table "+TableName+"("+
                col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text)";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String code,String name,String price)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(col2,code);
        c.put(col3,name);
        c.put(col4,price);

        long status=db.insert(TableName,null,c);

        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor searchData(String procode)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        String query="select * from "+TableName+ " where "+
                col2+"='"+procode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
}

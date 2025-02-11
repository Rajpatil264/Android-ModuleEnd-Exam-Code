package com.rajvardhan.android_87325.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.rajvardhan.android_87325.entities.ElectronicStore;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="classwork.db";
    public static final String TABLE_NAME="electronic";
    public static final String COL_1="pid";
    public static final String COL_2="pname";
    public static final String COL_3="category";
    public static final String COL_4="price";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(pid integer primary key,pname text,category text,price text)");
    }

    public List<ElectronicStore> getAllProducts(){
        List<ElectronicStore> storeList=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        while(cursor.moveToNext()){
            ElectronicStore store;
            int productId=cursor.getInt(0);
            String productName=cursor.getString(1);
            String category=cursor.getString(2);
            String price=cursor.getString(3);
            store=new ElectronicStore(productId,productName,category,price);
            storeList.add(store);
        }
        return storeList;
    }

    public void insertProduct(ElectronicStore store) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, store.getPid());
        contentValues.put(COL_2, store.getPname());
        contentValues.put(COL_3, store.getCategory());
        contentValues.put(COL_4, store.getPrice());
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteProduct(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,"pid=?",new String[]{String.valueOf(id)});
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
}

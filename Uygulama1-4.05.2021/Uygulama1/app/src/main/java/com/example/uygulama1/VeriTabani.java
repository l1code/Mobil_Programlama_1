package com.example.uygulama1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class VeriTabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "yemekler";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLO_YEMEK = "yemek";
    private static final String ROW_ID = "Id";
    private static final String ROW_AD = "ad";
    private static final String ROW_FIYAT = "fiyat";
    private static final String ROW_GORSEL="gorsel";

    public VeriTabani(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_YEMEK + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " VARCHAR NOT NULL, "
                + ROW_FIYAT + " VARCHAR NOT NULL, "
                + ROW_GORSEL + " BLOG NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_YEMEK);
        onCreate(db);
    }

    public void VeriEkle(String ad, String fiyat, byte[] image){
        SQLiteDatabase db=this.getWritableDatabase();
        try{
            ContentValues cv=new ContentValues();
            cv.put(ROW_AD,ad);
            cv.put(ROW_FIYAT,fiyat);
            cv.put(ROW_GORSEL,image);
            db.insert(TABLO_YEMEK,null,cv);

        }catch(Exception ex){
            Log.i("",ex.toString());
        }

        db.close();
    }


    public void SorgulaVeri(String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor VeriListele(String sql){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);
    }
}

package com.example.veritabaniislemler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "musteriler";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLO_KISILER = "kisiler";
    private static final String ROW_ID = "id";
    private static final String ROW_AD = "ad";
    private static final String ROW_SOYAD = "soyad";
    private static final String ROW_TEL = "tel";

    public Veritabani(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_KISILER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_SOYAD + " TEXT NOT NULL, "
                + ROW_TEL + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_KISILER);
        onCreate(db);
    }

    public void VeriEkle(String ad, String soyad, String tel){
        SQLiteDatabase db=this.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_AD, ad);
            cv.put(ROW_SOYAD, soyad);
            cv.put(ROW_TEL, tel);

            db.insert(TABLO_KISILER, null, cv);
        }catch(Exception ex){
            Log.i("",ex.toString());
        }

        db.close();
    }

    public void VeriDuzenle(int ID, String ad, String soyad, String telefon){
        SQLiteDatabase db=this.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_AD, ad);
            cv.put(ROW_SOYAD, soyad);
            cv.put(ROW_TEL, telefon);

            String sorgu = ROW_ID + " = '" + ID + "'";
            db.update(TABLO_KISILER, cv, sorgu, null);
        }catch(Exception ex){
            Log.i("",ex.toString());
        }

        db.close();
    }

    public void VeriSil(int ID){
        SQLiteDatabase db=this.getWritableDatabase();

        try {
            String sorgu = ROW_ID + " = '" + ID + "'";
            db.delete(TABLO_KISILER, sorgu, null);
        }catch(Exception ex){
            Log.i("",ex.toString());
        }
    }

    public List<String> VeriListele(){
        List<String> veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();

        String[] sutunlar={ROW_ID,ROW_AD,ROW_SOYAD,ROW_TEL};

        try {
            Cursor cursor = db.query(TABLO_KISILER, sutunlar, null, null, null, null, null);
            while (cursor.moveToNext()) {
                veriler.add(cursor.getInt(0) + "-" + cursor.getString(1)
                        + "-" + cursor.getString(2) + "-" + cursor.getString(3));
            }
        }catch(Exception ex){
            Log.i("",ex.toString());
        }

        db.close();
        return veriler;
    }
}

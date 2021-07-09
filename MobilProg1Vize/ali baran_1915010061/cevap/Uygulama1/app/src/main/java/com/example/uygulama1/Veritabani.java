package com.example.uygulama1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME="Kutuphane1.db";
    private static final  int DATABASE_VERSION=1;

    private static final String TABLO_AD="Kitaplık";
    private static final String ROW_ID="id";
    private static final String ROW_BASLIK="kBaslik";
    private static final String ROW_YAZAR="kYazar";
    private static final String ROW_SAYFA="kSayfaSayisi";
    private Context context;


     Veritabani(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_AD +
                " (" + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ROW_BASLIK + " TEXT, " +
                ROW_YAZAR + " TEXT, " +
                ROW_SAYFA + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLO_AD);
        onCreate(db);
    }

    void KitapEkle(String baslik,String yazar,int sayfalar){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ROW_BASLIK,baslik);
        cv.put(ROW_YAZAR,yazar);
        cv.put(ROW_SAYFA,sayfalar);
        long onay=db.insert(TABLO_AD,null,cv);
        Mesajlar ms=new Mesajlar();
        ms.Onay(onay,context);
    }

    Cursor KitapListele(){
        String sorgu="SELECT * FROM " + TABLO_AD;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=null;
        if (db != null)
        {
            cursor=db.rawQuery(sorgu,null);
        }
        return cursor;
    }

    void KitapGuncelle(String id,String baslik,String yazar,String sayfalar){
         SQLiteDatabase db=this.getWritableDatabase();
         ContentValues cv=new ContentValues();
         cv.put(ROW_BASLIK, baslik);
         cv.put(ROW_YAZAR, yazar);
         cv.put(ROW_SAYFA, sayfalar);

         long onay =db.update(TABLO_AD,cv," id=?",new String[]{id});
         Mesajlar ms=new Mesajlar();
         ms.Onay(onay,context);

    }

    void TekKitapSil(String id){
         SQLiteDatabase db=this.getWritableDatabase();
         long onay=db.delete(TABLO_AD,"id=?",new String[]{id});
        Mesajlar ms=new Mesajlar();
        ms.Onay(onay,context);
    }

    void HepsiniKitapSil(){
         SQLiteDatabase db=this.getWritableDatabase();
         db.execSQL("DELETE FROM " + TABLO_AD);
    }


}

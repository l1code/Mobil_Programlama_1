package com.example.uygulama1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText etYemekAdi, etYemekFiyat;
    private Button btnGorselSec, btnYemekEkle, btnYemekListele;


    private ImageView ivGorsel;


    private static final int IMAGE_PICK_CODE=2;
    private static final int IstekKodGaleri=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baslangic();
    }
    private void baslangic(){
        etYemekAdi=findViewById(R.id.etYemekAdi);
        etYemekFiyat=findViewById(R.id.etYemekFiyat);
        btnGorselSec=findViewById(R.id.btnGorselSec);
        btnYemekEkle=findViewById(R.id.btnEkle);
        btnYemekListele=findViewById(R.id.btnYemekListe);

        ivGorsel=findViewById(R.id.ivYemekGorsel);
    }

    public void YemekSec(View v){
        //kullanıcıdan uygulamanıza izin vermesini istiyoruz.
        //(String[]) Yani aynı anda birden fazla izin istemek için kullanılabilir bu metod.
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},IstekKodGaleri);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==IstekKodGaleri){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent();

                intent.setType("image/*");
                //herhangi bir dosya seçmek için kullanılıyor.
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Dosya Seç"),IstekKodGaleri);
            }else{
                Toast.makeText(this, "Dosya Erişim İzniniz Yok.", Toast.LENGTH_SHORT).show();
            }

            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==IstekKodGaleri && resultCode==RESULT_OK && data.getData()!=null){

            Uri uri=data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ivGorsel.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void YemekEkle(View v){
        String yemekAdi=etYemekAdi.getText().toString();
        String yemekFiyat=etYemekFiyat.getText().toString();

        try {
            byte[] gorsel=GorselToByte();
            VeriTabani vt = new VeriTabani(this);

            vt.VeriEkle(yemekAdi,yemekFiyat,gorsel);

            Toast.makeText(this, ""+new  Mesajlar().Basarili(), Toast.LENGTH_SHORT).show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public byte[] GorselToByte(){
        Bitmap bitmap=((BitmapDrawable)ivGorsel.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }

    public void Temizle(){
        etYemekAdi.setText("");
        etYemekFiyat.setText("");
        ivGorsel.setImageResource(R.mipmap.ic_launcher);
    }
}

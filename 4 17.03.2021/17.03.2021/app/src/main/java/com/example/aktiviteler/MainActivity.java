package com.example.aktiviteler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIkinci, btnRenk, btnToplama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Islemler();
    }

    public int Toplama(){
        int sayi1=10;
        int sayi2=19;

        int toplam=sayi1+sayi2;
        return toplam;
    }

    public void Islemler(){
        btnIkinci=findViewById(R.id.btnIkinci);
        btnRenk=findViewById(R.id.btnRenk);

        ////Eklenen her activity sınıfının AndroidManifest.xml
        // dosyasına ekleneceğini unutmayın. Yoksa hata alırsınız

        btnIkinci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IkinciActivity.class));
            }
        });


        btnRenk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RenkActivity.class));
            }
        });

        btnToplama=findViewById(R.id.btnTopla);

        btnToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sonuc=Toplama();
                Toast.makeText(getApplicationContext(), String.valueOf(sonuc), Toast.LENGTH_LONG).show();
            }
        });

    }
}

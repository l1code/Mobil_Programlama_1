package com.example.uygulama1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KitapEkleActivity extends AppCompatActivity {

    EditText etBaslik,etYazar,etSayfa;
    Button btn_ekle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_ekle);

        etBaslik=findViewById(R.id.etBaslik);
        etYazar=findViewById(R.id.etYazar);
        etSayfa=findViewById(R.id.etSayfaSayisi);
        btn_ekle=findViewById(R.id.btnKitapEkle);
        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani db=new Veritabani(KitapEkleActivity.this);
                db.KitapEkle(etBaslik.getText().toString().trim(),
                        etYazar.getText().toString().trim(),
                Integer.valueOf(etSayfa.getText().toString().trim()));

            }
        });

    }
}
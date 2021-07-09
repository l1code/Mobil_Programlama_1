package com.example.uygulama1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuncelleActivity extends AppCompatActivity {

    EditText guncelle_baslik,guncelle_yazar,guncelle_sayfalar;
    Button guncelle_kitap_btn,guncelle_SilKitap_btn;

    String id,baslik,yazar,sayfalar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        guncelle_baslik=findViewById(R.id.etGuncelleBaslik);
        guncelle_yazar=findViewById(R.id.etGuncelleYazar);
        guncelle_sayfalar=findViewById(R.id.etGuncelleSayfaSayisi);
        guncelle_kitap_btn=findViewById(R.id.btnGuncelleKitap);
        guncelle_SilKitap_btn=findViewById(R.id.btnSilKitap);

        VeriAlveAta();
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(baslik);
        }


        guncelle_kitap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Veritabani db=new Veritabani(GuncelleActivity.this);
            baslik=guncelle_baslik.getText().toString().trim();
            yazar=guncelle_yazar.getText().toString().trim();
            sayfalar=guncelle_sayfalar.getText().toString().trim();
            db.KitapGuncelle(id,baslik,yazar,sayfalar);
            }
        });

        guncelle_SilKitap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SilmeOnayKutusu();
            }
        });


    }

    void VeriAlveAta(){
        if (getIntent().hasExtra("id")
                && getIntent().hasExtra("baslik")
                && getIntent().hasExtra("yazar")
                && getIntent().hasExtra("sayfaSayisi")){

            id=getIntent().getStringExtra("id");
            baslik=getIntent().getStringExtra("baslik");
            yazar=getIntent().getStringExtra("yazar");
            sayfalar=getIntent().getStringExtra("sayfaSayisi");

            guncelle_baslik.setText(baslik);
            guncelle_yazar.setText(yazar);
            guncelle_sayfalar.setText(sayfalar);
        }
        else{
            Toast.makeText(this,"Veri Yok",Toast.LENGTH_LONG).show();
        }
    }

    void SilmeOnayKutusu(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(baslik +" Silmek istiyormusun " + " ?");
        builder.setMessage(baslik+" kitabını silmek istiyormusun "+" ?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Veritabani db=new Veritabani(GuncelleActivity.this);
                db.TekKitapSil(id);
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


}
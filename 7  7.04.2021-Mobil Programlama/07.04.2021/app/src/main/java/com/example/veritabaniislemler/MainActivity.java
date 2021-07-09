package com.example.veritabaniislemler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etAd,etSoyad,etTel;
    private Button btnKaydet, btnListele,btnSil,btnGuncelle;
    private ListView lstVeriListele;

    int idBul=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAd=findViewById(R.id.etAd);
        etSoyad=findViewById(R.id.etSoyad);
        etTel=findViewById(R.id.etTel);
        btnKaydet=findViewById(R.id.btnKaydet);

        btnListele=findViewById(R.id.btnListele);
        lstVeriListele=findViewById(R.id.lstListele);

        btnSil=findViewById(R.id.btnSil);
        btnGuncelle=findViewById(R.id.btnGuncelle);

        ListViewDinleme();
    }

    public void Ekle(View v){
        String gelenAd=etAd.getText().toString();
        String gelenSoyad=etSoyad.getText().toString();
        String gelenTel=etTel.getText().toString();

        Veritabani vt=new Veritabani(MainActivity.this);
        vt.VeriEkle(gelenAd,gelenSoyad,gelenTel);
        Listele();
    }

    public void Guncelle(View v){
        String gelenAd=etAd.getText().toString();
        String gelenSoyad=etSoyad.getText().toString();
        String gelenTel=etTel.getText().toString();

        Veritabani vt=new Veritabani(MainActivity.this);
        vt.VeriDuzenle(idBul,gelenAd,gelenSoyad,gelenTel);

        Listele();
    }

    public void Sil(View v){
        Veritabani vt=new Veritabani(MainActivity.this);
        vt.VeriSil(idBul);
        Listele();

    }

    public void Listele(){
        Veritabani vt=new Veritabani(MainActivity.this);
        List<String> liste=vt.VeriListele();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,liste);
        lstVeriListele.setAdapter(adapter);
    }


    public void ListViewDinleme(){
        lstVeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String parca=lstVeriListele.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), parca, Toast.LENGTH_SHORT).show();

                String[] itemBol=parca.split("-");
                idBul=Integer.valueOf(itemBol[0].toString());
                etAd.setText(itemBol[1].toString());
                etSoyad.setText(itemBol[2].toString());
                etTel.setText(itemBol[3].toString());
            }
        });
    }


    public void Listeleme(View v){
        Listele();
    }


}

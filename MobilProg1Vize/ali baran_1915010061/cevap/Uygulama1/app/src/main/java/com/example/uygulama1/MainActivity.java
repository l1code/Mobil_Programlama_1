package com.example.uygulama1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton  faBtn;
    ImageView ivVeriYok;
    TextView tvVeriYok;

    Veritabani db;

    ArrayList<String> kitap_id,kitap_baslik,kitap_yazar,kitap_sayfalar;

    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rvGoster);
        faBtn=findViewById(R.id.faBtnEkle);
        ivVeriYok=findViewById(R.id.ivVeriYok);
        tvVeriYok=findViewById(R.id.tvVeriYok);
        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,KitapEkleActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

        db=new Veritabani(MainActivity.this);
        kitap_id=new ArrayList<>();
        kitap_baslik=new ArrayList<>();
        kitap_yazar=new ArrayList<>();
        kitap_sayfalar=new ArrayList<>();

        KitaplarıGoster();
        adapter=new myAdapter(MainActivity.this,MainActivity.this,kitap_id,kitap_baslik,kitap_yazar,kitap_sayfalar);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            recreate();
        }
    }

    void KitaplarıGoster(){
        Cursor cursor=db.KitapListele();
        if (cursor.getCount()==0){
            ivVeriYok.setVisibility(View.VISIBLE);
            tvVeriYok.setVisibility(View.VISIBLE);
        }
        else{
            while (cursor.moveToNext()){
                kitap_id.add(cursor.getString(0));
                kitap_baslik.add(cursor.getString(1));
                kitap_yazar.add(cursor.getString(2));
                kitap_sayfalar.add(cursor.getString(3));

                ivVeriYok.setVisibility(View.GONE);
                tvVeriYok.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSil){
            SilmeOnayKutusu();
        }
        return super.onOptionsItemSelected(item);
    }

    void SilmeOnayKutusu(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Hepsini Sil ?");
        builder.setMessage("Hepsini silmek istediğinize emin misiniz?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Veritabani db=new Veritabani(MainActivity.this);
                db.HepsiniKitapSil();

                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
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
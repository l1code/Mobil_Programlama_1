package com.example.application1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] ulkeler={"Türkiye", "Almanya", "Avusturya", "Amerika","İngiltere",
            "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
            "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
            "Makedonya", "Ukrayna", "İsviçre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewIslemler();
    }


    public void ListViewIslemler(){
        //(A) Kullanıcıya gösterilen ListView'a ulaşabilmek için onun bir referansını almak
        ListView liste=(ListView)findViewById(R.id.lstSehirler);
        Log.i("Bilgi","ListView Oluşturuldu");
        //(B) ListView'ımızı verilerle (ülke adları) buluşturacak olan Adapter'ı tanımlamak

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler);

        Log.i("ArrayAdapter","Array Adapter Oluşturuldu");

         /*
            (B) adımında, new deyimiyle bir ArrayAdapter oluşturuyoruz.
            Oradaki <String>, ArrayAdapter'ın içinde tutacağı verilerin türünü belirten bir deyim.
            ArrayAdapter'ın yapılandırıcı metodundaki parametrelerse şu anlama geliyor:

                this: Context. Yani bağlam.
                Bu this deyimiyle değer olarak Activity'nin kendisinin dönmesini sağlıyoruz (Activity sınıfının içindeyiz).
                ArrayAdapter, çalıştığı yerle ilgili bilgiyi Context'e ulaşarak bulur.
                android.R.layout.simple_list_item_1: resource. Bu parametre, kullanıcının göreceği listenin yerleşim dosyasıdır.
                Listemiz bu layout dosyasından bina edilecektir.
                android.R.id.text1: textViewResourceId Bu parametre, layout dosyasındaki TextView'ın adını (id) verdiğimiz yerdir.
                Her bir veri buradaki bir TextView'a basılır.

            (C) adımında artık ayarlamalarını bitirdiğimiz ArrayAdapter'i listemize gösteriyoruz
         */

        //(C) ListView'ımıza, bağlanacağı Adapter'ı belirtmek
        liste.setAdapter(veriAdaptoru);

        Log.i("ListView","ListView'e bağlanacak Adapter Belirlendi");

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder diyalog=new AlertDialog.Builder(MainActivity.this);

                diyalog.setMessage(ulkeler[position])
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });


                diyalog.create().show();
                Log.i("Liste Tıklama","Listeye Tıklandığından Gelecek Mesaj İçin Diyalog Penceresi Oluşturuldu.");
            }
        });

    }
}

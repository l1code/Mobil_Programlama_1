package com.example.listeleme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMarka;
    ArrayList<Data> dataList=new ArrayList<>();

    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMarka=findViewById(R.id.rvMarka);

        //kontrollerin nasıl hizalanacağını gösteriyor.
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0); //en üste gelsin.

        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2,LinearLayoutManager.VERTICAL,false);
        rvMarka.setLayoutManager(gridLayoutManager);

        rvMarka.setHasFixedSize(true); //performans amaçlı

        dataList.add(new Data("IOS","2001",R.mipmap.ios));
        dataList.add(new Data("Apple","1996",R.mipmap.apple));
        dataList.add(new Data("Android","2002",R.mipmap.android));
        dataList.add(new Data("Linux","1985",R.mipmap.linux));

        Donustur donustur=new Donustur(dataList,context);

        //Burada adapterımızı listemize bağlamak için setAdapter() kullanıyoruz.
        //Farklı olarak LinearLayoutManager sınıfından bir nesne üretip
        // listemizin orientation bilgisini set ediyoruz.
        // Bu sayede listemizi yatay, dikey, grid ve staggered
        // şeklinde gösterebiliyoruz.Bu örneğimizde dikeyde listeledik.

        rvMarka.setAdapter(donustur);
    }
}

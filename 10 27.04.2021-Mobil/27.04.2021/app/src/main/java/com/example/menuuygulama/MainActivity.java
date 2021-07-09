package com.example.menuuygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

        rvMarka.setLayoutManager(layoutManager);
        rvMarka.setHasFixedSize(true); //performans amaçlı

        dataList.add(new Data("IOS","2001",R.mipmap.ios));
        dataList.add(new Data("Apple","1996",R.mipmap.apple));
        dataList.add(new Data("Android","2002",R.mipmap.android));
        dataList.add(new Data("Linux","1985",R.mipmap.linux));

        Donustur donustur=new Donustur(dataList,context);
        rvMarka.setAdapter(donustur);

        //Burada adapterımızı listemize bağlamak için setAdapter() kullanıyoruz.
        //Farklı olarak LinearLayoutManager sınıfından bir nesne üretip
        // listemizin orientation bilgisini set ediyoruz.
        // Bu sayede listemizi yatay, dikey, grid ve staggered
        // şeklinde gösterebiliyoruz.Bu örneğimizde dikeyde listeledik.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

        switch (id){
            case R.id.menuDikey:
                linearLayoutManager=new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvMarka.setLayoutManager(linearLayoutManager);
                break;
            case R.id.menuGrid:
                GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
                rvMarka.setLayoutManager(gridLayoutManager);
                break;
            case R.id.menuKarisik:
                StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL);
                rvMarka.setLayoutManager(staggeredGridLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

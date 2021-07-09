package com.example.lecture1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Donustur extends RecyclerView.Adapter<Donustur.ViewHolder> {

    //Kodlarımızı inceleyecek olursak bilmemiz gereken
    // ilk şey Adapter’ımızı RecyclerView.Adapter’dan extend etmek.
    // Bu işlemi yaptığımızda import etmemiz gereken methodları tek tek inceleyelim.

    ArrayList<Data> dataList=new ArrayList<>();

    LayoutInflater layoutInflater;
    Context context;

    public Donustur(ArrayList<Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    //onCreateViewHolder() : Bu method adaptör oluşturulduğunda oluşturduğumuz
    // ViewHolder'ın başlatılması için çağrılır.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //her bir satır için temsil edilecek arayüz seçilir.
        layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.satir_list,parent,false);
        ViewHolder vh=new ViewHolder(v); //bir kez çalışıyor.
        return vh;
    }

    //onBindViewHolder() : onCreateViewHolder’dan
    // dönen verileri bağlama işlemini gerçekleştirildiği metotdur.
    //onBindViewHolder() methodu içerisinde onCreateViewHolder’dan
    // dönen holder ve position parametre olarak gönderip listenin
    // hangi veri ile dolacağını ve elemana tıklanma olaylarını kontrol edebileceğiz.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //her bir görünümün içeriğini belirliyoruz.
        //dataList.get(position) satırın kendisi
        holder.tvAciklama.setText(dataList.get(position).getAciklama());
        holder.tvCikisTarih.setText(dataList.get(position).getCikisTarihi());
        holder.ivImage.setImageResource(dataList.get(position).getImgSrc());
        //setImageResource resim ekleme işlemini sağlar.

        //her satıra tıklandığında bir işlem yaptırmak istiyorsanız.
        holder.llIcerik.setTag(holder);

        holder.llIcerik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder holder=(ViewHolder)v.getTag();
                int position=holder.getLayoutPosition();
                String aciklama=dataList.get(position).getAciklama();
                String cikisTarih=dataList.get(position).getCikisTarihi();

                Toast.makeText(context, ""+aciklama, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, ""+cikisTarih, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //getItemCount() : Listemizin eleman sayısını döndüren metottur.
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    //ViewHolder Her bir satırımızın içinde bulunan bileşenleri tanımlama işleminin yapıldığı metottur.
    //performansı artırabilmek için kullanımı zorunlu tutulan sınıf.
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAciklama,tvCikisTarih;
        ImageView ivImage;
        LinearLayout llIcerik;

        public ViewHolder(View itemView){
            super(itemView);

            tvAciklama=itemView.findViewById(R.id.tvAciklama);
            tvCikisTarih=itemView.findViewById(R.id.tvCikisTarih);
            ivImage=itemView.findViewById(R.id.ivImage);
            llIcerik=itemView.findViewById(R.id.llIcerik);

        }
    }

}

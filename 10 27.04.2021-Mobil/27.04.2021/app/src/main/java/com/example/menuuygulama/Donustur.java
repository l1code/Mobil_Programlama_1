package com.example.menuuygulama;

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

import java.util.ArrayList;

public class Donustur extends RecyclerView.Adapter<Donustur.ViewHolder> {
    ArrayList<Data> dataList=new ArrayList<>();

    LayoutInflater layoutInflater;
    Context context;

    public Donustur(ArrayList<Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public Donustur.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.satir_list,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Donustur.ViewHolder holder, int position) {
        holder.tvAciklama.setText(dataList.get(position).getAciklama());
        holder.tvCikisTarih.setText(dataList.get(position).getCikisTarihi());
        holder.ivImage.setImageResource(dataList.get(position).getImgSrc());

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

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAciklama,tvCikisTarih;
        ImageView ivImage;
        LinearLayout llIcerik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAciklama=itemView.findViewById(R.id.tvAciklama);
            tvCikisTarih=itemView.findViewById(R.id.tvCikisTarih);
            ivImage=itemView.findViewById(R.id.ivImage);
            llIcerik=itemView.findViewById(R.id.llIcerik);
        }
    }
}

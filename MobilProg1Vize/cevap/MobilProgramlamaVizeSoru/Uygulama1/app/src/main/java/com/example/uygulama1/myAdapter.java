package com.example.uygulama1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    Activity activity;
    ArrayList kitap_id,kitap_baslik,kitap_yazar,kitap_sayfalar;
    Context context;

    Animation ceviri_anim;

    myAdapter(Activity activity,Context context,ArrayList kitap_id,ArrayList kitap_baslik,ArrayList kitap_yazar,ArrayList kitap_sayfalar){
        this.activity=activity;
        this.context=context;
        this.kitap_id=kitap_id;
        this.kitap_baslik=kitap_baslik;
        this.kitap_yazar=kitap_yazar;
        this.kitap_sayfalar=kitap_sayfalar;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.satir_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_kitap_id.setText(String.valueOf(kitap_id.get(position)));
        holder.txt_kitap_baslik.setText(String.valueOf(kitap_baslik.get(position)));
        holder.txt_kitap_yazar.setText(String.valueOf(kitap_yazar.get(position)));
        holder.txt_kitap_sayfalar.setText(String.valueOf(kitap_sayfalar.get(position)));
        holder.llsatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,GuncelleActivity.class);
                intent.putExtra("id",String.valueOf(kitap_id.get(position)));
                intent.putExtra("baslik",String.valueOf(kitap_baslik.get(position)));
                intent.putExtra("yazar",String.valueOf(kitap_yazar.get(position)));
                intent.putExtra("sayfaSayisi",String.valueOf(kitap_sayfalar.get(position)));
                activity.startActivityForResult(intent,1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return kitap_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llsatir;
        TextView txt_kitap_id,txt_kitap_baslik,txt_kitap_yazar,txt_kitap_sayfalar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_kitap_id=itemView.findViewById(R.id.txt_kitap_id);
            txt_kitap_baslik=itemView.findViewById(R.id.txt_kitap_baslik);
            txt_kitap_yazar=itemView.findViewById(R.id.txt_kitap_yazar);
            txt_kitap_sayfalar=itemView.findViewById(R.id.txt_kitap_sayfalar);
            llsatir=itemView.findViewById(R.id.llsatir);
            ceviri_anim= AnimationUtils.loadAnimation(context,R.anim.ceviri_anim);
            llsatir.setAnimation(ceviri_anim);

        }
    }



}

package com.example.uygulama1;

import android.content.Context;
import android.widget.Toast;

public class Mesajlar {

    public  void  Onay(long onay, Context context){
        if (onay==1){
             Toast.makeText(context,"İşlem Başarılı!!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,"İşlem Başarısız!!",Toast.LENGTH_LONG).show();
        }
    }

}

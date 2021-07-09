package com.example.lecture5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MesajGosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesaj_goster);

        Intent intent=getIntent();
        String mesaj=intent.getStringExtra(MainActivity.Extra_Message);

        TextView tvGelenMesaj=findViewById(R.id.tvGelenMesaj);
        tvGelenMesaj.setText(mesaj);
    }
}

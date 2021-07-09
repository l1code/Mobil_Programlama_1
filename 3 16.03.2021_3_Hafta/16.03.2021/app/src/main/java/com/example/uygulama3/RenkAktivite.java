package com.example.uygulama3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RenkAktivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk_aktivite);

        Toast.makeText(getApplicationContext(), "Renk aktivite", Toast.LENGTH_SHORT).show();
        RenkButonlariniDinle();
    }


    public void RenkButonlariniDinle(){
        final Button btnSiyah=findViewById(R.id.btnBlack);
        final Button btnKoyuYesil=findViewById(R.id.btnGreenDark);
        final Button btnGri=findViewById(R.id.btnGray);
        final Button btnPortakalSarisi=findViewById(R.id.btnOrange);
        final Button btnRenkBasaDon=findViewById(R.id.btnRenkMainGeriDon);

        btnSiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkAktivite.this,

                        btnSiyah.getText(), Toast.LENGTH_LONG).show();
            }
        });


        btnKoyuYesil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkAktivite.this,
                        btnKoyuYesil.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btnGri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkAktivite.this, btnGri.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        btnPortakalSarisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkAktivite.this, btnPortakalSarisi.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        btnRenkBasaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RenkAktivite.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.aktiviteler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RenkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk);

        RenkButonlariDinle();
    }

    public void RenkButonlariDinle(){
        final Button btnSiyah=findViewById(R.id.btnBlack);
        final Button btnKoyuYesil=findViewById(R.id.btnGreenDark);
        final Button btnGri=findViewById(R.id.btnGray);
        final Button btnPortakalSarisi=findViewById(R.id.btnOrange);
        final Button btnRenkBasaDon=findViewById(R.id.btnRenkMainGeriDon);


        btnSiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkActivity.this, btnSiyah.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btnKoyuYesil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkActivity.this, btnKoyuYesil.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btnGri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkActivity.this, btnGri.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btnPortakalSarisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenkActivity.this, btnPortakalSarisi.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btnRenkBasaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RenkActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

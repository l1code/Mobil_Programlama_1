package com.example.aktiviteler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class IkinciActivity extends AppCompatActivity {

    public static final int HORIZANTAL_EXAMPLE = 0;
    public static final int VERTICAL_EXAMPLE = 1;
    public static final int WEIGHT_EXAMPLE = 2;
    public static final int GRAVITY_EXAMPLE = 3;

    Button btnHorizontal, btnVertical, btnWeight, btnGravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);

        btnHorizontal=findViewById(R.id.btnHorizontal);
        btnVertical=findViewById(R.id.btnVertical);
        btnWeight=findViewById(R.id.btnWeight);
        btnGravity=findViewById(R.id.btnGravity);

        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Yatay Tıklandı", Toast.LENGTH_LONG).show();
                ShowExample(HORIZANTAL_EXAMPLE);
            }
        });

        btnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IkinciActivity.this, "Dikey Tıklandı", Toast.LENGTH_SHORT).show();
                ShowExample(VERTICAL_EXAMPLE);
            }
        });

        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IkinciActivity.this, "Ağırlık Tıklandı", Toast.LENGTH_SHORT).show();
                ShowExample(WEIGHT_EXAMPLE);
            }
        });

        btnGravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IkinciActivity.this, "Yer Çekimi Butonu Tıklandı", Toast.LENGTH_SHORT).show();
                ShowExample(GRAVITY_EXAMPLE);
            }
        });
    }

    private void ShowExample(int exampleID){
        Intent intent=new Intent(IkinciActivity.this,IkinciActivity.class);
        intent.putExtra("ExampleID",exampleID);
        startActivity(intent);
    }
}

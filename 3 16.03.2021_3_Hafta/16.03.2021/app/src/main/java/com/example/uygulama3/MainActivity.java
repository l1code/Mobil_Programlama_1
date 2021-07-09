package com.example.uygulama3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIkinci;
    Button btnRenk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIkinci=findViewById(R.id.btnIkinci);
        btnRenk=findViewById(R.id.btnRenk);

        ////Eklenen her activity sınıfının AndroidManifest.xml
        // dosyasına ekleneceğini unutmayın. Yoksa hata alırsınız

        btnIkinci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IkinciAktivite.class));
            }
        });

        btnRenk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RenkAktivite.class));
            }
        });
    }
}

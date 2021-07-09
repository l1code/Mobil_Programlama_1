package com.example.fileapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText etDosyaAdi, etVeri;
    private Button btnKaydet,btnOku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDosyaAdi=findViewById(R.id.etDosyaAdi);
        etVeri=findViewById(R.id.etDosyaOku);


        btnKaydet=findViewById(R.id.btnKaydet);
        btnOku=findViewById(R.id.btnOku);
    }

    public void Kaydet(View v){
        String dosyaAdi=etDosyaAdi.getText().toString();
        String veri=etVeri.getText().toString();
        FileOutputStream fos=null;
        try {

             fos=openFileOutput(dosyaAdi+".txt", Context.MODE_PRIVATE);
             fos.write(veri.getBytes());
             fos.close();
             etVeri.getText().clear();

            Toast.makeText(getApplicationContext(),"Kaydedildi "+getFilesDir()+" / "+ dosyaAdi, Toast.LENGTH_LONG).show();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void Oku(View v){
        FileInputStream fis=null;
        String dosyaAdi=etDosyaAdi.getText().toString();
        String veri=etVeri.getText().toString();

        try {
            fis=openFileInput(dosyaAdi+".txt");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            etVeri.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

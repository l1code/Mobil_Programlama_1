package com.example.fileapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnTarihSec, btnKaydet, btnOku;
    private EditText etTarih, etDosyaAdi,etDosyaVeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTarihSec=(Button)findViewById(R.id.btnTarihSec);
        etTarih=(EditText)findViewById(R.id.etTarih);

        btnKaydet=(Button)findViewById(R.id.btnKaydet);
        btnOku=(Button)findViewById(R.id.btnOku);

        etDosyaAdi=(EditText)findViewById(R.id.etDosyaAdi);
        etDosyaVeri=(EditText)findViewById(R.id.etDosyaVeri);
    }

    public void Oku(View v){

        FileInputStream fis=null;
        String dosyaAdi=etDosyaAdi.getText().toString();

        try {
            File dosya=new File(this.getFilesDir(),dosyaAdi+".txt");

            fis=new FileInputStream(dosya);

            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            StringBuilder sb1=new StringBuilder();

            String text;
            int sayac=0;
            while((text=br.readLine())!=null){
                if (sayac==0) {
                    sb.append(text);
                }else{
                    sb1.append(text);
                }
                sayac++;
            }

            etTarih.setText(sb.toString());
            etDosyaVeri.setText(sb1.toString());

            br.close();
            isr.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"Okuma"+e.toString(),Toast.LENGTH_LONG).show();
        }catch(IOException e){
            Toast.makeText(getApplicationContext(),"Okuma"+e.toString(),Toast.LENGTH_LONG).show();
        }finally{
            if (fis!=null){
                try {
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void TarihSec(View v) {
        final Calendar takvim = Calendar.getInstance();
        int yil = takvim.get(Calendar.YEAR);
        int ay = takvim.get(Calendar.MONTH);
        int gun = takvim.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //ay de??eri 0 dan ba??lad?????? i??in (Ocak=0, ??ubat =1,...Aral??k=11)
                //de??eri 1 art??r??larak g??steriyoruz.

                month = month + 1;
                //year, month, dayOfMonth de??erleri se??ilen tarihin de??erleridir.
                //Edittext te bu de??erleri g??steriyoruz.
                etTarih.setText(dayOfMonth + "/" + month + "/" + year);
            }
        },yil, ay,gun);

        // datepicker a????ld??????nda set edilecek de??erleri buraya yaz??yoruz.
        // ??imdiki zaman?? g??stermesi i??in yukarda tanmlad??????mz de????kenleri kullanyoruz.

        dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "SE??", dpd);
        dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "??ptal", dpd);
        dpd.show();
    }

    public void Kaydet(View v){

        String dosyaAdi=etDosyaAdi.getText().toString();
        String tarih=etTarih.getText().toString();
        String dosyaVeri=etDosyaVeri.getText().toString();

        FileOutputStream fos=null;
        try {
        File dosya=new File(this.getFilesDir(),dosyaAdi+".txt");
        //??st ??ste ekleyebilmek i??in parametre true olmal??d??r.
            fos=new FileOutputStream(dosya,false);
            OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
            osw.write(tarih);
            osw.write("\n");
            osw.write(dosyaVeri);

            osw.close();
            fos.close();


            etTarih.getText().clear();
            etDosyaVeri.getText().clear();

            Toast.makeText(getApplicationContext(),"Kaydedildi "+getFilesDir()+" / "+dosyaAdi, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

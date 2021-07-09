package com.example.lecture6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean IslemBasildiMi=false;
    private double ilkSayi=0;
    private int ikinciSayiIndex=0;
    private char mevcutIslem;
    private String ekranIcerik="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView hesaplamaEkran=findViewById(R.id.hesaplamaEkran);
        final Button btn0=findViewById(R.id.btn0);
        final Button btn1=findViewById(R.id.btn1);
        final Button btn2=findViewById(R.id.btn2);
        final Button btn3=findViewById(R.id.btn3);
        final Button btn4=findViewById(R.id.btn4);
        final Button btn5=findViewById(R.id.btn5);
        final Button btn6=(Button)findViewById(R.id.btn6);
        final Button btn7=(Button)findViewById(R.id.btn7);
        final Button btn8=(Button)findViewById(R.id.btn8);
        final Button btn9=(Button)findViewById(R.id.btn9);
        final Button btnNokta=(Button)findViewById(R.id.btnNokta);
        final Button btnEsit=(Button)findViewById(R.id.btnEsit);
        final Button btnCikarma=(Button)findViewById(R.id.btnCikarma);
        final Button btnToplama=(Button)findViewById(R.id.btnToplama);
        final Button btnBolme=(Button)findViewById(R.id.btnBolme);
        final Button btnCarpma=(Button)findViewById(R.id.btnCarpma);

        final View.OnClickListener hesaplamaDinleme=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=v.getId();

                switch (id){
                    case R.id.btn0:
                        hesaplamaEkran.append("0");
                        break;
                    case R.id.btn1:
                        hesaplamaEkran.append("1");;
                        break;
                    case R.id.btn2:
                        hesaplamaEkran.append("2");
                        break;
                    case R.id.btn3:
                        hesaplamaEkran.append("3");
                        break;
                    case R.id.btn4:
                        hesaplamaEkran.append("4");
                        break;
                    case R.id.btn5:
                        hesaplamaEkran.append("5");
                        break;
                    case R.id.btn6:
                        hesaplamaEkran.append("6");
                        break;
                    case R.id.btn7:
                        hesaplamaEkran.append("7");
                        break;
                    case R.id.btn8:
                        hesaplamaEkran.append("8");
                        break;
                    case R.id.btn9:
                        hesaplamaEkran.append("9");
                        break;
                    case R.id.btnNokta:
                        hesaplamaEkran.append(".");
                        break;
                    case R.id.btnEsit:
                        if(IslemBasildiMi){
                            if(mevcutIslem=='+'){
                                ekranIcerik=hesaplamaEkran.getText().toString();
                                String ikinciSayiString=ekranIcerik.substring(ikinciSayiIndex,ekranIcerik.length());
                                double ikinciSayi=Double.parseDouble(ikinciSayiString);
                                ilkSayi=ilkSayi+ikinciSayi;
                                hesaplamaEkran.setText(String.valueOf(ilkSayi));

                            }else if(mevcutIslem=='-'){
                                ekranIcerik=hesaplamaEkran.getText().toString();
                                String ikinciSayiString=ekranIcerik.substring(ikinciSayiIndex,ekranIcerik.length());
                                double ikinciSayi=Double.parseDouble(ikinciSayiString);
                                ilkSayi-=ikinciSayi;
                                hesaplamaEkran.setText(String.valueOf(ilkSayi));


                            }else if(mevcutIslem=='*'){
                                ekranIcerik=hesaplamaEkran.getText().toString();
                                String ikinciSayiString=ekranIcerik.substring(ikinciSayiIndex,ekranIcerik.length());
                                double ikinciSayi=Double.parseDouble(ikinciSayiString);
                                ilkSayi=ilkSayi*ikinciSayi;
                                hesaplamaEkran.setText(String.valueOf(ilkSayi));

                            }else if(mevcutIslem=='/'){
                                ekranIcerik=hesaplamaEkran.getText().toString();
                                String ikinciSayiString=ekranIcerik.substring(ikinciSayiIndex,ekranIcerik.length());
                                double ikinciSayi=Double.parseDouble(ikinciSayiString);
                                ilkSayi/=ikinciSayi;
                                hesaplamaEkran.setText(String.valueOf(ilkSayi));
                            }
                        }
                        break;
                    case R.id.btnToplama:
                        ekranIcerik=hesaplamaEkran.getText().toString();
                        ikinciSayiIndex=ekranIcerik.length()+1;
                        ilkSayi=Double.parseDouble(ekranIcerik);
                        hesaplamaEkran.append("+");
                        IslemBasildiMi=true;
                        mevcutIslem='+';
                        break;
                    case R.id.btnCikarma:
                        ekranIcerik=hesaplamaEkran.getText().toString();
                        ikinciSayiIndex=ekranIcerik.length()+1;
                        ilkSayi=Double.parseDouble(ekranIcerik);
                        hesaplamaEkran.append("-");
                        IslemBasildiMi=true;
                        mevcutIslem='-';
                        break;
                    case R.id.btnCarpma:
                        Log.i("carpma","carpma giriş");
                        ekranIcerik=hesaplamaEkran.getText().toString();
                        ikinciSayiIndex=ekranIcerik.length()+1;
                        ilkSayi=Double.parseDouble(ekranIcerik);
                        hesaplamaEkran.append("*");
                        IslemBasildiMi=true;
                        mevcutIslem='*';
                        Log.i("carpma son","mevcut işlem *");
                        break;
                    case R.id.btnBolme:
                        ekranIcerik=hesaplamaEkran.getText().toString();
                        ikinciSayiIndex=ekranIcerik.length()+1;
                        ilkSayi=Double.parseDouble(ekranIcerik);
                        hesaplamaEkran.append("/");
                        IslemBasildiMi=true;
                        mevcutIslem='/';
                        break;
                }
            }
        };

        btn0.setOnClickListener(hesaplamaDinleme);
        btn1.setOnClickListener(hesaplamaDinleme);
        btn2.setOnClickListener(hesaplamaDinleme);
        btn3.setOnClickListener(hesaplamaDinleme);
        btn4.setOnClickListener(hesaplamaDinleme);
        btn5.setOnClickListener(hesaplamaDinleme);
        btn6.setOnClickListener(hesaplamaDinleme);
        btn7.setOnClickListener(hesaplamaDinleme);
        btn8.setOnClickListener(hesaplamaDinleme);
        btn9.setOnClickListener(hesaplamaDinleme);
        btnNokta.setOnClickListener(hesaplamaDinleme);
        btnEsit.setOnClickListener(hesaplamaDinleme);
        btnCikarma.setOnClickListener(hesaplamaDinleme);
        btnToplama.setOnClickListener(hesaplamaDinleme);
        btnBolme.setOnClickListener(hesaplamaDinleme);
        btnCarpma.setOnClickListener(hesaplamaDinleme);


        final Button btnSil=findViewById(R.id.btnSil);
        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ekranElemanlar=hesaplamaEkran.getText().toString();
                int uzunluk=ekranElemanlar.length();
                if(uzunluk>0){
                    ekranElemanlar=ekranElemanlar.substring(0,uzunluk-1);
                    hesaplamaEkran.setText(ekranElemanlar);
                }
            }
        });

        final Button btnTemizle=findViewById(R.id.btnTemizle);
        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplamaEkran.setText("");
            }
        });

        //ikinci aktivite de linear layout yerleşim düzenini anlatırken weihht ile width ya da height düzeninde 0dp
        //kullanımını göstermek için anlamlı bir örnek;
        //Intent intent=new Intent(MainActivity.this,linearlayoutaktivite.class);
        //MainActivity.this.startActivity(intent);
        //MainActivity.this.finish();

    }
}

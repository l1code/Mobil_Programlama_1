package com.example.lecture5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String Extra_Message="TBMYO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     /*
    Sistemin android:onClick'e verilen metod adıyla buradaki
    metod adını eşleştirebilmesi için metod imzası tıpkı burada gösterildiği gibi olmalıdır.
    Metod mutlaka

    public olmalı
    void dönüş değeri içermeli
    tek parametre olarak View almalı (bu View tıklanmış olan View oluyor)
     */

    /** kullanıcı gönder düğmesine basınca aktif olacak**/
    public void mesajGonder(View view) {
 /*
        Bundan sonraki aşamada, bu metodun içini metin kutusunun içeriğini okumak ve
         girilen metni diğer Activity'ye göndermek için dolduracağız.
         */

        Intent intent=new Intent(this,MesajGosterActivity.class);
        EditText etMesaj=findViewById(R.id.etMesaj);
        String mesaj=etMesaj.getText().toString();
        intent.putExtra(Extra_Message,mesaj);
        startActivity(intent);
    }

     /*

    Bir Intent, farklı bileşenler arasında (iki Activity gibi) çalışma zamanında
     bağlama (runtime binding) sağlayan nesnedir.
     Intent, bir uygulamanın "bir şeyi yapmaya niyetlenmesini"
     ifade eder. Intent'leri çok çeşitli görevlerde kullanabilirsiniz
     fakat başka bir Activity'yi başlatma işlemlerinde sıkça kullanılırlar.
     */
}

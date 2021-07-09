package com.example.menuuygulama;

public class Data {
    //eklemek istenen verilerin kalıbını oluşturuyoruz.

    // Bu sınıfı oluşturmamızın sebebi her bir satırımızda
    // farklı tiplerden oluşan verilere tek seferde ulaşıp satırı inflate etmek
    //Veri modelimizde fotoğraflara sırasıyla erişmek için int tipinde resim, string tipinde tarih
    // ve açıklaması için String tipinde değişkenler oluşturduk. Kodlarımızı incelemeden önce
    // her bir satırımızda kullanacağımız görseller res/drawable klasörüne eklemeyi unutmayalım.

    String aciklama;
    String cikisTarihi;
    int imgSrc;

    //ctrl basılı iken mouse sol tuş ile bütün değerler işaretlenir.


    public Data(String aciklama, String cikisTarihi, int imgSrc) {
        this.aciklama = aciklama;
        this.cikisTarihi = cikisTarihi;
        this.imgSrc = imgSrc;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}

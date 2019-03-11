package com.example.app_ukazka;

public class Zbozi {
    float cena;
    float vaha;
    float cenaKg;

    public float getCenaKg() {
        return cenaKg;
    }

    public void setCenaKg(float cenaKg) {
        this.cenaKg = cenaKg;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setVaha(float vaha) {
        this.vaha = vaha;
    }

    public float getCena() {
        return cena;
    }

    public float getVaha() {
        return vaha;
    }

    public Zbozi(float cena, float vaha) {
        this.cena = cena;
        this.vaha = vaha;
        this.cenaKg = Calc(cena,vaha);
    }
    @Override
    public String toString() {

        float tmp = Calc(cena,vaha);
        return tmp+" Kč";
    }

    public float Calc(float cena, float vaha)
    {
            return ((1000*cena)/vaha);
    }

    public static String Porovnej(Zbozi prvni, Zbozi druhe)
    {
        if(prvni.cenaKg<druhe.cenaKg)
            return "První je levnější";
        else
            return "Druhý je levnější";
    }
}

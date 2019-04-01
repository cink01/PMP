package com.example.app_ukazka;

public class Zbozi {
    float cena;
    float vaha;
    float cenaKg;

    public float getCenaKg() { return cenaKg; }
    public void setCenaKg(float cenaKg) { this.cenaKg = cenaKg; }
    public void setCena(float cena) { this.cena = cena; }
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
        this.cenaKg = Calc();
    }
    @Override
    public String toString() { return cenaKg + " Kč"; }
    public float Calc() {return ((1000 * this.cena) / this.vaha);}
    public static String Porovnej(Zbozi prvni, Zbozi druhe) {
        if (prvni.cenaKg < druhe.cenaKg)
            return "První zboží je levnější.";
        if (prvni.cenaKg > druhe.cenaKg)
            return "Druhý zboží je levnější.";
        return "Obě zboží mají stejnou cenu za kilogram.";
    }
}
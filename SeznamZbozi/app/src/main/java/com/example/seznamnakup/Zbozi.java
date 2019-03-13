package com.example.seznamnakup;

public class Zbozi {

String nazev;
float cena;
float pocet;
float celkem;

    public Zbozi(String nazev, float cena, float pocet) {
        this.nazev = nazev;
        this.cena = cena;
        this.pocet = pocet;
        this.celkem=CalcCelkem();
    }

    public float CalcCelkem()
    {
        return this.cena*this.pocet;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public float getPocet() {
        return pocet;
    }

    public void setPocet(float pocet) {
        this.pocet = pocet;
    }

    public float getVaha() {
        return vaha;
    }

    public void setVaha(float vaha) {
        this.vaha = vaha;
    }

    public float getCenaKg() {
        return cenaKg;
    }

    public void setCenaKg(float cenaKg) {
        this.cenaKg = cenaKg;
    }
}
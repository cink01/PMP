package com.example.xml_app;

public class Zbozi {
    private String nazev;
    private String cena;
    private String pocet;

    public Zbozi(){}

    public Zbozi(String nazev, String cena, String pocet) {
        this.nazev = nazev;
        this.cena = cena;
        this.pocet = pocet;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getPocet() {
        return pocet;
    }

    public void setPocet(String pocet) {
        this.pocet = pocet;
    }
}

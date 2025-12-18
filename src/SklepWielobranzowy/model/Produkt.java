package SklepWielobranzowy.model;

import SklepWielobranzowy.model.TypProduktu;

public class Produkt{
    private String numerProduktu;
    private String nazwa;
    private TypProduktu typProduktu;
    private double cena;
    private int stanMagazynowy;

    public Produkt(String numerProduktu, String nazwa, TypProduktu typProduktu, double cena, int stanMagazynowy) {
        this.numerProduktu = numerProduktu;
        this.nazwa = nazwa;
        this.typProduktu = typProduktu;
        this.cena = cena;
        this.stanMagazynowy = stanMagazynowy;
    }
    public double getCena() {
        return cena;
}

    @Override
    public String toString() {
        return "Produkt{" +
                "numerProduktu='" + numerProduktu + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", typProduktu=" + typProduktu +
                ", cena=" + cena +
                ", stanMagazynowy=" + stanMagazynowy +
                '}';
    }
}




package SklepWielobranzowy.model;

public class Produkt {
    private String nazwa;
    private TypProduktu typ;
    private double cena;
    private int stanMagazynowy;

    public Produkt(String nazwa, TypProduktu typ, double cena, int stanMagazynowy) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.cena = cena;
        this.stanMagazynowy = stanMagazynowy;
    }

    public String getNazwa() { return nazwa; }
    public TypProduktu getTyp() { return typ; }
    public double getCena() { return cena; }
    public int getStanMagazynowy() { return stanMagazynowy; }

    public void dodajDoMagazynu(int ilosc) {
        this.stanMagazynowy += ilosc;
    }

    public boolean odejmijZMagazynu(int ilosc) {
        if (stanMagazynowy >= ilosc) {
            stanMagazynowy -= ilosc;
            return true;
        }
        return false;
    }


    public String toString() {
        return nazwa + " (" + typ + ") - " + cena + " zł [Stan: " + stanMagazynowy + "]";
    }
}

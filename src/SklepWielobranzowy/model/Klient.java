package SklepWielobranzowy.model;

public class Klient {
    private String imie;
    private String nazwisko;
    private String numerKlienta;
    private String adres;

    public Klient(String imie, String nazwisko, String numerKlienta, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKlienta = numerKlienta;
        this.adres = adres;
    }

    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public String getNumerKlienta() { return numerKlienta; }
    public String getAdres() { return adres; }

    public String toString() {
        return imie + " " + nazwisko + " (ID: " + numerKlienta + ")";
    }
}
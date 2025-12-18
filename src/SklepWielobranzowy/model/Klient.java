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

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerKlienta='" + numerKlienta + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}

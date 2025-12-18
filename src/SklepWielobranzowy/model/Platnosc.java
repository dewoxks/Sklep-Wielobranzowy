package SklepWielobranzowy.model;

public class Platnosc {
    private double kwota;
    private RodzajPlatnosci rodzajPlatnosci;
    private String dane;

    public Platnosc(double kwota, RodzajPlatnosci rodzajPlatnosci, String dane) {
        this.kwota = kwota;
        this.rodzajPlatnosci = rodzajPlatnosci;
        this.dane = dane;
    }

}

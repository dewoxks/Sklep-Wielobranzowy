package SklepWielobranzowy.model;

import java.time.LocalDate;

public class Platnosc {
    private double kwota;
    private RodzajPlatnosci rodzajPlatnosci;
    private LocalDate dataPlatnosci;

    public Platnosc(double kwota, RodzajPlatnosci rodzajPlatnosci) {
        this.kwota = kwota;
        this.rodzajPlatnosci = rodzajPlatnosci;
        this.dataPlatnosci = LocalDate.now();
    }

    public double getKwota() { return kwota; }
    public RodzajPlatnosci getRodzajPlatnosci() { return rodzajPlatnosci; }
    public LocalDate getDataPlatnosci() { return dataPlatnosci; }

    public String toString() {
        return "Płatność: " + kwota + " zł (" + rodzajPlatnosci + ") - " + dataPlatnosci;
    }
}
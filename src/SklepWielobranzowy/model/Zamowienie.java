package SklepWielobranzowy.model;

import java.time.LocalDate;
import java.util.*;

public class Zamowienie {
    private Klient klient;
    private List<Produkt> produkty;
    private LocalDate dataZamowienia;
    private double lacznaKwota;
    private StatusZamowienia status;

    public Zamowienie(Klient klient, List<Produkt> produkty) {
        this.klient = klient;
        this.produkty = new ArrayList<>(produkty);
        this.dataZamowienia = LocalDate.now();
        this.lacznaKwota = obliczLacznaKwote();
        this.status = StatusZamowienia.NOWE;
    }

    private double obliczLacznaKwote() {
        double suma = 0;
        for(Produkt p : produkty) {
            suma += p.getCena();
        }
        return suma;
    }

    public Klient getKlient() { return klient; }
    public List<Produkt> getProdukty() { return produkty; }
    public LocalDate getDataZamowienia() { return dataZamowienia; }
    public double getLacznaKwota() { return lacznaKwota; }
    public StatusZamowienia getStatus() { return status; }

    public void aktualizujStatus(StatusZamowienia nowyStatus) {
        this.status = nowyStatus;
    }

    public String toString() {
        return "Zamówienie: " + klient.getNumerKlienta() + " | Data: " + dataZamowienia +
                " | Kwota: " + lacznaKwota + " zł | Status: " + status;
    }
} .
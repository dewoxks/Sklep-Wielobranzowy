package SklepWielobranzowy.model;

import java.time.LocalDate;
import java.util.*;

public class ZgloszenieZamowienia {
    private Klient klient;
    private List<String> numeryProduktow;
    private LocalDate dataZgloszenia;

    public ZgloszenieZamowienia(Klient klient, List<String> numeryProduktow) {
        this.klient = klient;
        this.numeryProduktow = new ArrayList<>(numeryProduktow);
        this.dataZgloszenia = LocalDate.now();
    }

    public Klient getKlient() { return klient; }
    public List<String> getNumeryProduktow() { return numeryProduktow; }
    public LocalDate getDataZgloszenia() { return dataZgloszenia; }
}
package SklepWielobranzowy.model;

import java.util.*;

class SklepWielobranżowy {
    private List<Produkt> produkty;
    private List<Klient> klienci;
    private List<Zamowienie> zamowienia;
    private List<Platnosc> platnosci;
    private Map<Zamowienie, List<Platnosc>> historiaPlatnosci;

    public SklepWielobranżowy() {
        this.produkty = new ArrayList<>();
        this.klienci = new ArrayList<>();
        this.zamowienia = new ArrayList<>();
        this.platnosci = new ArrayList<>();
        this.historiaPlatnosci = new HashMap<>();
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
        System.out.println("Dodano produkt: " + produkt);
    }

    public void aktualizujStanMagazynowy(String nazwaProduktu, int nowystan) {
        for (Produkt p : produkty) {
            if (p.getNazwa().equals(nazwaProduktu)) {
                int roznica = nowystan - p.getStanMagazynowy();
                p.dodajDoMagazynu(roznica);
                System.out.println("Zaktualizowano stan: " + p);
                return;
            }
        }
        System.out.println("Nie znaleziono produktu: " + nazwaProduktu);
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
        System.out.println("Dodano klienta: " + klient);
    }

    public Zamowienie zlozZamowienie(Klient klient, List<Produkt> produktyDoZamowienia) {
        for (Produkt p : produktyDoZamowienia) {
            if (!p.odejmijZMagazynu(1)) {
                System.out.println("Brak wystarczającej ilości produktu: " + p.getNazwa());
                return null;
            }
        }

        Zamowienie zamowienie = new Zamowienie(klient, produktyDoZamowienia);
        zamowienia.add(zamowienie);
        historiaPlatnosci.put(zamowienie, new ArrayList<>());
        System.out.println("Złożono zamówienie: " + zamowienie);
        return zamowienie;
    }

    public void realizujZamowienie(Zamowienie zamowienie) {
        zamowienie.aktualizujStatus(StatusZamowienia.ZAKONCZONE);
        System.out.println("Zrealizowano zamówienie dla klienta: " + zamowienie.getKlient());
    }

    public void zarejestrujPlatnosc(Zamowienie zamowienie, RodzajPlatnosci rodzaj) {
        Platnosc platnosc = new Platnosc(zamowienie.getLacznaKwota(), rodzaj);
        platnosci.add(platnosc);
        historiaPlatnosci.get(zamowienie).add(platnosc);
        System.out.println("Zarejestrowano płatność: " + platnosc);
    }

    public void generujRaportSprzedazy() {
        System.out.println("\n=== RAPORT SPRZEDAŻY ===");
        double suma = 0;
        for (Zamowienie z : zamowienia) {
            System.out.println(z);
            suma += z.getLacznaKwota();
        }
        System.out.println("Łączna wartość zamówień: " + suma + " zł\n");
    }

    public void generujRaportStanowMagazynowych() {
        System.out.println("\n=== RAPORT STANÓW MAGAZYNOWYCH ===");
        for (Produkt p : produkty) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void wyswietlHistorieTransakcji() {
        System.out.println("\n=== HISTORIA TRANSAKCJI ===");
        for (Map.Entry<Zamowienie, List<Platnosc>> entry : historiaPlatnosci.entrySet()) {
            System.out.println(entry.getKey());
            for (Platnosc p : entry.getValue()) {
                System.out.println("  " + p);
            }
        }
        System.out.println();
    }

    public double naliczCeneZRabatem(Produkt produkt, double procentRabatu) {
        return produkt.getCena() * (1 - procentRabatu / 100);
    }

    public List<Produkt> getProdukty() { return produkty; }
    public List<Klient> getKlienci() { return klienci; }
    public List<Zamowienie> getZamowienia() { return zamowienia; }
}

public class Main {
    public static void main(String[] args) {
        SklepWielobranżowy sklep = new SklepWielobranżowy();

        Produkt p1 = new Produkt("Chleb", TypProduktu.SPOZYWCZE, 4.50, 50);
        Produkt p2 = new Produkt("Laptop", TypProduktu.ELEKTRONIKA, 2500.00, 10);
        Produkt p3 = new Produkt("Koszulka", TypProduktu.ODZIEZ, 45.00, 30);

        sklep.dodajProdukt(p1);
        sklep.dodajProdukt(p2);
        sklep.dodajProdukt(p3);

        Klient k1 = new Klient("Jan", "Kowalski", "K001", "ul. Główna 1, Warszawa");
        Klient k2 = new Klient("Anna", "Nowak", "K002", "ul. Kwiatowa 5, Kraków");

        sklep.dodajKlienta(k1);
        sklep.dodajKlienta(k2);

        List<Produkt> zamowienie1 = Arrays.asList(p1, p2);
        Zamowienie z1 = sklep.zlozZamowienie(k1, zamowienie1);

        if (z1 != null) {
            sklep.zarejestrujPlatnosc(z1, RodzajPlatnosci.KARTA);
            sklep.realizujZamowienie(z1);
        }

        List<Produkt> zamowienie2 = Arrays.asList(p3);
        Zamowienie z2 = sklep.zlozZamowienie(k2, zamowienie2);

        if (z2 != null) {
            sklep.zarejestrujPlatnosc(z2, RodzajPlatnosci.BLIK);
        }

        sklep.generujRaportSprzedazy();
        sklep.generujRaportStanowMagazynowych();
        sklep.wyswietlHistorieTransakcji();

        System.out.println("Cena z 10% rabatem dla produktu " + p2.getNazwa() + ": "
                + sklep.naliczCeneZRabatem(p2, 10) + " zł");
    }
}
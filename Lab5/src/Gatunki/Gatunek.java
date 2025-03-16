package Gatunki;

public class Gatunek {
    private String nazwa_rodzaju;
    private String nazwa_gatunkowa;
    private int liczba_chromosomow_2n;
    private int liczba_chromosomow_x;
    private String opis;

    public Gatunek(String nazwa_rodzaju, String nazwa_gatunkowa, int liczba_chromosomow_2n, int liczba_chromosomow_x, String opis) {
        this.nazwa_rodzaju = nazwa_rodzaju;
        this.nazwa_gatunkowa = nazwa_gatunkowa;
        this.liczba_chromosomow_2n = liczba_chromosomow_2n;
        this.liczba_chromosomow_x = liczba_chromosomow_x;
        this.opis = opis;
    }

    public String pelna_nazwa() {
        return nazwa_rodzaju+ " " +nazwa_gatunkowa;
    }

    public int liczba_chromosomow_haploidalnych() {
        return liczba_chromosomow_2n / 2;
    }

    public void WyswietlDane() {
        System.out.println(pelna_nazwa());
        System.out.println("Liczba chromosomow 2n: "+liczba_chromosomow_2n);
        System.out.println("Liczba chromosomow x: "+liczba_chromosomow_x);
        System.out.println("Opis: "+opis);
    }

    public Gatunek Klonuj_gatunek() {
        return new Gatunek(nazwa_rodzaju, nazwa_gatunkowa, liczba_chromosomow_2n, liczba_chromosomow_x, opis);
    }

}

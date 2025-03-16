package Budynki;

import java.time.LocalDate;

public class Budynek {
    private String nazwa;
    private int rok_budowy;
    private int liczba_pieter;

    public Budynek(String nazwa, int liczba_pieter, int rok_budowy) {
        this.nazwa = nazwa;
        this.liczba_pieter = liczba_pieter;
        this.rok_budowy = rok_budowy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getRok_budowy() {
        return rok_budowy;
    }

    public int getLiczba_pieter() {
        return liczba_pieter;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setRok_budowy(int rok_budowy) {
        this.rok_budowy = rok_budowy;
    }

    public void setLiczba_pieter(int liczba_pieter) {
        this.liczba_pieter = liczba_pieter;
    }

    public int Ilelatmabudynek() {
        int rok = LocalDate.now().getYear();
        return rok - rok_budowy;
    }


    public void WyswietlDane() {
        System.out.println("Nazwa budynku: "+nazwa);
        System.out.println("Rok budowy budynku: "+rok_budowy);
        System.out.println("Liczba pieter budynku: "+liczba_pieter);
        System.out.println("Wiek budynku to: " + Ilelatmabudynek() + " lat");
    }
}

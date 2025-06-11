package com.example.projekcik;

import javafx.beans.property.*;

public class Produkt {
    private final BooleanProperty zaznaczony;
    private final BooleanProperty zaznaczonydousuniecia;
    private final IntegerProperty iloscdozakupu;
    private Integer id_produktu;
    private String nazwa;
    private double cena;
    private Integer ilosc;
    private String opis;

    public Produkt(Integer id_produktu, String nazwa, double cena, Integer ilosc, String opis) {
        this.id_produktu = id_produktu;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.opis = opis;
        this.zaznaczony = new SimpleBooleanProperty(false);
        this.zaznaczonydousuniecia = new SimpleBooleanProperty(false);
        this.iloscdozakupu = new SimpleIntegerProperty(1);
    }

    public Integer getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(Integer id_produkt) {
        this.id_produktu = id_produkt;
    }

    public int getIloscdozakupu() {
        return iloscdozakupu.get();
    }

    public void setIloscdozakupu(int ilosc) {
        this.iloscdozakupu.set(ilosc);
    }

    public IntegerProperty IloscdozakupuProperty() {
        return iloscdozakupu;
    }

    public boolean isZaznaczonydousuniecia() {
        return zaznaczonydousuniecia.get();
    }

    public void setZaznaczonydousuniecia(boolean zaznaczonydousuniecia) {
        this.zaznaczonydousuniecia.set(zaznaczonydousuniecia);
    }

    public BooleanProperty zaznaczonydousunieciaProperty() {
        return zaznaczonydousuniecia;
    }

    public boolean isZaznaczony() {
        return zaznaczony.get();
    }

    public BooleanProperty zaznaczonyProperty() {
        return zaznaczony;
    }

    public void setZaznaczony(boolean zaznaczony) {
        this.zaznaczony.set(zaznaczony);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}

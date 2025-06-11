package com.example.projekcik;

import java.util.Date;

public class Zamowienie {

    private int id_zamowienia;
    private double cena_zamowienia;
    private String status_zamowienia;
    private String login;
    private String imie;
    private String nazwisko;
    private Date data_zamowienia;

    public Zamowienie(int id_zamowienia, double cena_zamowienia, String status_zamowienia, String login, String imie, String nazwisko, Date data_zamowienia) {
        this.id_zamowienia = id_zamowienia;
        this.cena_zamowienia = cena_zamowienia;
        this.status_zamowienia = status_zamowienia;
        this.login = login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_zamowienia = data_zamowienia;
    }

    public Zamowienie(int id_zamowienia, double cenazamowenia, String statuszamownienia, String login, Date datazamowienia) {
        this.id_zamowienia = id_zamowienia;
        this.cena_zamowienia = cenazamowenia;
        this.status_zamowienia = statuszamownienia;
        this.login = login;
        this.data_zamowienia = datazamowienia;
    }

    public double getCena_zamowienia() {
        return cena_zamowienia;
    }

    public void setCena_zamowienia(double cena_zamowienia) {
        this.cena_zamowienia = cena_zamowienia;
    }

    public String getStatus_zamowienia() { return status_zamowienia; }

    public void setStatus_zamowienia(String status_zamowienia) {
        this.status_zamowienia = status_zamowienia;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(Date data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }
}

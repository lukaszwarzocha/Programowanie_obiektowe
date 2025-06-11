package com.example.projekcik;

public class Osoba {

    private String rola;
    private Integer id_klienta;
    private String login;
    private String imie;
    private String nazwisko;
    private String email;
    private String adres;

    public Osoba(Integer id_klienta, String rola, String login, String imie, String nazwisko, String email, String adres) {
        this.id_klienta = id_klienta;
        this.rola = rola;
        this.login = login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.adres = adres;
    }

    public Integer getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Integer id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String Wyswietlrola() {
        return rola;
    }
}
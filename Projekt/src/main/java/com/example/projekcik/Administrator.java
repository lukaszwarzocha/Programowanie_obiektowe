package com.example.projekcik;

public class Administrator extends Osoba {

    public Administrator(Integer id_klienta, String rola, String login, String imie, String nazwisko, String email, String adres) {
        super(id_klienta, rola, login, imie, nazwisko, email, adres);
    }

    @Override
    public String Wyswietlrola() {
        return "com.example.projekcik.Administrator";
    }
}

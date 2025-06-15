package com.example.projekcik;
import com.example.projekcik.Osoba;

public class Uzytkownik extends Osoba {

    public Uzytkownik(Integer id_klienta, String rola, String login, String imie, String nazwisko, String email, String adres) {
        super(id_klienta, rola, login, imie, nazwisko, email, adres);
    }

    @Override
    public String Wyswietlrola() {
        return "Uzytkownik";
    }
}
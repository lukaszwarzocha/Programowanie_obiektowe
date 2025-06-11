package com.example.projekcik.DB;

import com.example.projekcik.*;
import Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UserDAO {

    public void dodajUzytkownika(String login, String haslo, String imie, String nazwisko, int wiek, String email, String adres) throws SQLException {
        String sql = "INSERT INTO klienci (login,haslo,imie,nazwisko,wiek,email,adres,rola,saldo) VALUES (?,?,?,?,?,?,?,?,0)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, haslo);
            pstmt.setString(3, imie);
            pstmt.setString(4, nazwisko);
            pstmt.setInt(5, wiek);
            pstmt.setString(6, email);
            pstmt.setString(7, adres);
            pstmt.setString(8, "UZYTKOWNIK");
            pstmt.executeUpdate();
        }
    }

    public boolean UzytkownikIstnieje(String login) throws SQLException {
        String sql = "SELECT COUNT(*) FROM klienci WHERE login=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    public boolean EmailIstnieje(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM klienci WHERE email=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        }
    }

    public boolean ZalogujUzytkownik(String login, String haslo) throws SQLException {
        String sql = "SELECT * FROM klienci WHERE login = ? AND haslo = ? AND rola = 'UZYTKOWNIK'";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, haslo);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public boolean ZalogujAdministrator(String login, String haslo) throws SQLException {
        String sql = "SELECT * FROM klienci WHERE login = ? AND haslo = ? AND rola = 'ADMINISTRATOR'";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, haslo);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public double Wyswietlsaldo(String login) throws SQLException {
        String sql = "SELECT saldo FROM klienci WHERE login = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("saldo");
            }
            throw new SQLException("Nie udalo sie znalezc uzytkownika!");
        }
    }


    public void dodajProdukt(String nazwa, double cena, Integer ilosc, String opis) throws SQLException {
        String sql = "INSERT INTO produkty (nazwa,cena,ilosc,opis) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nazwa);
            pstmt.setDouble(2, cena);
            pstmt.setInt(3, ilosc);
            pstmt.setString(4, opis);
            pstmt.executeUpdate();
        }
    }

    public List<Produkt> pokazProdukty() throws SQLException {
        List<Produkt> produkty = new ArrayList<>();
        String sql = "SELECT * FROM produkty";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_produktu");
                String nazwa = rs.getString("nazwa");
                double cena = rs.getDouble("cena");
                Integer ilosc = rs.getInt("ilosc");
                String opis = rs.getString("opis");
                Produkt produkt = new Produkt(id, nazwa, cena, ilosc, opis);
                produkty.add(produkt);
            }
        }
        return produkty;
    }

    public void depozyt(String login, double amount) throws SQLException {
        String sql = "UPDATE klienci SET saldo = saldo + ? WHERE login = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, login);
            pstmt.executeUpdate();
        }
    }

    public void usunprodukt(int id_produktu) throws SQLException {
        String sql = "DELETE FROM produkty WHERE id_produktu = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_produktu);
            pstmt.executeUpdate();
        }
    }

    public void zakup(String login, double kwota) throws SQLException {
        String sql = "UPDATE klienci SET saldo = saldo - ? WHERE login = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, kwota);
            pstmt.setString(2, login);
            pstmt.executeUpdate();
        }
    }

    public void zaaktualizujiloscproduktu(int id_produktu, int nowailosc) throws SQLException {
        String sql = "UPDATE produkty SET ilosc = ? WHERE id_produktu = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nowailosc);
            pstmt.setInt(2, id_produktu);
            pstmt.executeUpdate();
        }
    }

    public int znajdzuzytkownikapologinie(String login) throws SQLException {
        String sql = "SELECT * FROM klienci WHERE login = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_klienta");
            }
            throw new SQLException("Nie udalo sie znalezc uzytkownika!");
        }
    }

    public void dodajzamowienie(int id_klienta, Date data_zamowienia, String status_zamowienia, double cena_zamowienia) throws SQLException {
        String sql = "INSERT INTO public.zamowienia(id_klienta, data_zamowienia, status_zamowienia, cena_zamowienia) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_klienta);
            pstmt.setDate(2, data_zamowienia);
            pstmt.setString(3, status_zamowienia);
            pstmt.setDouble(4, cena_zamowienia);
            pstmt.executeUpdate();
        }
    }

    public List<Zamowienie> pokazzamowieniawszystkich() throws SQLException {
        List<Zamowienie> zamowienia = new ArrayList<>();
        String sql = "SELECT z.id_zamowienia, z.status_zamowienia, z.cena_zamowienia, z.data_zamowienia, k.login, k.imie, k.nazwisko FROM zamowienia z JOIN klienci k ON z.id_klienta = k.id_klienta";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id_zamowienia = rs.getInt("id_zamowienia");
                String statuszamownienia = rs.getString("status_zamowienia");
                String login = rs.getString("login");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                double cenazamowenia = rs.getDouble("cena_zamowienia");
                Date datazamowienia = rs.getDate("data_zamowienia");
                Zamowienie zamowienie = new Zamowienie(id_zamowienia, cenazamowenia, statuszamownienia, login, imie, nazwisko, datazamowienia);
                zamowienia.add(zamowienie);
            }
        }
        return zamowienia;
    }

    public List<Zamowienie> pokazzamowieniaklienta(String login) throws SQLException {
        List<Zamowienie> zamowienia = new ArrayList<>();
        String sql = "SELECT z.id_zamowienia, z.status_zamowienia, z.cena_zamowienia, z.data_zamowienia, k.login FROM zamowienia z JOIN klienci k ON z.id_klienta = k.id_klienta WHERE k.login = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id_zamowienia = rs.getInt("id_zamowienia");
                String statuszamownienia = rs.getString("status_zamowienia");
                double cenazamowenia = rs.getDouble("cena_zamowienia");
                Date datazamowienia = rs.getDate("data_zamowienia");
                Zamowienie zamowienie = new Zamowienie(id_zamowienia, cenazamowenia, statuszamownienia, login, datazamowienia);
                zamowienia.add(zamowienie);
            }
        }
        return zamowienia;
    }

    public List<Osoba> pokazuzytkownikow() throws SQLException {
        List<Osoba> osoba = new ArrayList<>();
        String sql = "SELECT id_klienta, login, imie, nazwisko, email, adres, rola FROM klienci WHERE rola = ? ORDER BY id_klienta ASC";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "UZYTKOWNIK");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id_klienta = rs.getInt("id_klienta");
                String login = rs.getString("login");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String email = rs.getString("email");
                String adres = rs.getString("adres");
                String rola = rs.getString("rola");
                Osoba osoby = new Osoba(id_klienta, rola, login, imie, nazwisko, email, adres);
                osoba.add(osoby);
            }
        }
        return osoba;
    }

    public List<Produkt> szukajProdukt(String filtrowanie) throws SQLException {
        List<Produkt> produkty = new ArrayList<>();
        String sql = "SELECT * FROM produkty WHERE LOWER(nazwa) LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,filtrowanie.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_produktu");
                String nazwa = rs.getString("nazwa");
                double cena = rs.getDouble("cena");
                Integer ilosc = rs.getInt("ilosc");
                String opis = rs.getString("opis");
                Produkt produkt = new Produkt(id, nazwa, cena, ilosc, opis);
                produkty.add(produkt);
            }
        }
        return produkty;
    }
    }


package com.example.projekcik;

import com.example.projekcik.DB.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AdminPanelController extends LoginController {

    @FXML
    private Label roleLabel;
    @FXML
    private Label loginLabel;
    @FXML
    public VBox dodajpanel;
    @FXML
    public VBox dodajpanel2;
    @FXML
    public VBox dodajpanel3;
    @FXML
    public VBox dodajpanel4;

    @FXML
    public TextField nazwaField;
    @FXML
    public TextField cenaField;
    @FXML
    public TextField iloscField;
    @FXML
    public TextArea opisField;

    @FXML
    public TableView<Zamowienie> widokzamowien;
    @FXML
    public TableColumn<Zamowienie, String> statusField;
    @FXML
    public TableColumn<Zamowienie, Number> cenazamowieniaField;
    @FXML
    public TableColumn<Zamowienie, String> loginuzytkownikaField;
    @FXML
    public TableColumn<Zamowienie, String> imieField;
    @FXML
    public TableColumn<Zamowienie, String> nazwiskoField;
    @FXML
    public TableColumn<Zamowienie, Date> datazamowieniaField;
    @FXML
    public TableView<Produkt> widok;
    @FXML
    public TableColumn<Produkt, Boolean> zaznaczField;
    @FXML
    public TableColumn<Produkt, String> nazwaproduktuField;
    @FXML
    public TableColumn<Produkt, Integer> iloscproduktuField;
    @FXML
    public TableColumn<Produkt, Number> cenaproduktuField;
    @FXML
    public TableColumn<Produkt, String> opisproduktuField;

    @FXML
    public TableView<Osoba> widokuzytkownikow;
    @FXML
    public TableColumn<Osoba, Integer> id_klientaField;
    @FXML
    public TableColumn<Osoba, String> loginklientaField;
    @FXML
    public TableColumn<Osoba, String> imieklientaField;
    @FXML
    public TableColumn<Osoba, String> nazwiskoklientaField;
    @FXML
    public TableColumn<Osoba, String> emailklientaField;
    @FXML
    public TableColumn<Osoba, String> adresklientaField;

    public void ukryjpanel() {
        dodajpanel.setVisible(false);
        dodajpanel.setManaged(false);
        dodajpanel2.setVisible(false);
        dodajpanel2.setManaged(false);
        dodajpanel3.setVisible(false);
        dodajpanel3.setManaged(false);
        dodajpanel4.setVisible(false);
        dodajpanel4.setManaged(false);
    }

    public void pokazpanel(VBox paneldopokazania) {
        dodajpanel.setVisible(false);
        dodajpanel.setManaged(false);
        dodajpanel2.setVisible(false);
        dodajpanel2.setManaged(false);
        dodajpanel3.setVisible(false);
        dodajpanel3.setManaged(false);
        dodajpanel4.setVisible(false);
        dodajpanel4.setManaged(false);
        paneldopokazania.setVisible(true);
        paneldopokazania.setManaged(true);
    }

    public void wyswietlogin(String login) {
        loginLabel.setText(login);
        loginLabel.setVisible(true);
        roleLabel.setText("(com.example.projekcik.Administrator)");
    }

    public void dodajprodukt() {
        pokazpanel(dodajpanel);
    }

    public void dodaj() {
        String nazwa = nazwaField.getText();
        String cenaText = cenaField.getText();
        String iloscText = iloscField.getText();
        String opis = opisField.getText();

        if (nazwa.isEmpty() || cenaText.isEmpty() || iloscText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Uzupelnij pola!");
            alert.showAndWait();
            return;
        }
        int ilosc;
        ilosc = Integer.parseInt(iloscText);
        if (ilosc < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Musisz wystawic minimum jeden produkt!");
            alert.showAndWait();
            return;
        }
        try {
            UserDAO userDAO = new UserDAO();
            double cena = Double.parseDouble(cenaText.replaceAll(",", "."));
            int ilosc2 = Integer.parseInt(iloscText);

            userDAO.dodajProdukt(nazwa, cena, ilosc2, opis);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Dodales produkt!");
            alert.showAndWait();
            wyczysc();
            ukryjpanel();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Blad dodawania produktu!");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Cena musi byc liczba!");
            alert.showAndWait();
        }
    }

    public void wyczysc() {
        nazwaField.clear();
        cenaField.clear();
        iloscField.clear();
        opisField.clear();
    }

    public void pokazprodukty() {
        pokazpanel(dodajpanel3);
        showproducts();
    }

    public void showproducts() {
        try {
            UserDAO userDAO = new UserDAO();
            List<Produkt> produkty = userDAO.pokazProdukty();
            ObservableList<Produkt> produkts = FXCollections.observableArrayList(produkty);
            widok.setItems(produkts);
            widok.setEditable(true);
            zaznaczField.setEditable(true);
            zaznaczField.setCellValueFactory(new PropertyValueFactory<>("zaznaczony"));
            zaznaczField.setCellFactory(CheckBoxTableCell.forTableColumn(zaznaczField));
            nazwaproduktuField.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            iloscproduktuField.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
            cenaproduktuField.setCellValueFactory(new PropertyValueFactory<>("cena"));
            opisproduktuField.setCellValueFactory(new PropertyValueFactory<>("opis"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Ladowanie produktow nie powiodlo sie!");
            alert.showAndWait();
        }
    }

    public void usunprodukt() {
        ObservableList<Produkt> zazprodukty = FXCollections.observableArrayList();
        for (Produkt produkt : widok.getItems()) {
            if (produkt.isZaznaczony()) {
                zazprodukty.add(produkt);
            }
        }
        if (zazprodukty.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Pierw zaznacz produkt ktory chcesz usunac!");
            alert.showAndWait();
            return;
        }
        try {
            UserDAO userDAO = new UserDAO();
            for (Produkt produkt : zazprodukty) {
                userDAO.usunprodukt(produkt.getId_produktu());
            }
            widok.getItems().removeAll(zazprodukty);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Zaznaczone produkty zostaly usuniete!");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad przy usuwaniu produktow!");
            alert.showAndWait();
        }
    }

    public void pokazzamowieniapanel() {
        pokazpanel(dodajpanel2);
        pokazzamowienia();
    }

    public void pokazzamowienia() {
        try {
            UserDAO userDAO = new UserDAO();
            List<Zamowienie> zamowienia = userDAO.pokazzamowieniawszystkich();
            ObservableList<Zamowienie> zamowienia2 = FXCollections.observableArrayList(zamowienia);
            widokzamowien.setItems(zamowienia2);
            loginuzytkownikaField.setCellValueFactory(new PropertyValueFactory<>("login"));
            imieField.setCellValueFactory(new PropertyValueFactory<>("imie"));
            nazwiskoField.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            statusField.setCellValueFactory(new PropertyValueFactory<>("status_zamowienia"));
            datazamowieniaField.setCellValueFactory(new PropertyValueFactory<>("data_zamowienia"));
            cenazamowieniaField.setCellValueFactory(new PropertyValueFactory<>("cena_zamowienia"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Ladowanie wszystkich zamowien nie powiodlo sie!");
            alert.showAndWait();
        }
    }

    @FXML
    public void wyloguj() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Wylogowales sie!");
        alert.showAndWait();
        Stage panelglowny = (Stage) loginLabel.getScene().getWindow();
        panelglowny.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 260, 310);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Sklep ogrodowy");
        stage.setScene(scene);
        stage.show();
    }

    public void pokazklientowpanel() {
        pokazpanel(dodajpanel4);
        pokazklientow();
    }

    private void pokazklientow() {
        try {
            UserDAO userDAO = new UserDAO();
            List<Osoba> zamowienia = userDAO.pokazuzytkownikow();
            ObservableList<Osoba> osoby = FXCollections.observableArrayList(zamowienia);
            widokuzytkownikow.setItems(osoby);
            id_klientaField.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
            loginklientaField.setCellValueFactory(new PropertyValueFactory<>("login"));
            imieklientaField.setCellValueFactory(new PropertyValueFactory<>("imie"));
            nazwiskoklientaField.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            emailklientaField.setCellValueFactory(new PropertyValueFactory<>("email"));
            adresklientaField.setCellValueFactory(new PropertyValueFactory<>("adres"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Ladowanie wszystkich klientow nie powiodlo sie!");
            alert.showAndWait();
        }
    }
}
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
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserPanelController extends LoginController {

    private String loginuzytkownika;
    private final Set<Integer> zaznaczoneProdukty = new HashSet<>();
    @FXML
    private TextField szukanieField;
    @FXML
    private Label loginLabel;
    @FXML
    private Label saldoLabel;
    @FXML
    public VBox dodajpanel2;
    @FXML
    public VBox dodajpanel3;
    @FXML
    public VBox dodajpanel4;
    @FXML
    public VBox dodajpanel5;
    @FXML
    public TextField cenacalkowitaField;
    @FXML
    public TextField wplataField;
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
    public TableView<Produkt> widokkoszyka;
    @FXML
    public TableColumn<Produkt, Integer> koszykiloscproduktudozakupuField;
    @FXML
    public TableColumn<Produkt, String> koszyknazwaproduktuField;
    @FXML
    public TableColumn<Produkt, Integer> koszykiloscproduktuField;
    @FXML
    public TableColumn<Produkt, Number> koszykcenaproduktuField;
    @FXML
    public TableColumn<Produkt, Boolean> usuncheckbox;
    @FXML
    public TableView<Zamowienie> widokzamowien;
    @FXML
    public TableColumn<Zamowienie, String> statusField;
    @FXML
    public TableColumn<Zamowienie, Number> cenazamowieniaField;
    @FXML
    public TableColumn<Zamowienie, java.util.Date> datazamowieniaField;

    public void ukryjpanel() {
        dodajpanel2.setVisible(false);
        dodajpanel2.setManaged(false);
        dodajpanel3.setVisible(false);
        dodajpanel3.setManaged(false);
        dodajpanel4.setVisible(false);
        dodajpanel4.setManaged(false);
        dodajpanel5.setVisible(false);
        dodajpanel5.setManaged(false);
    }

    public void pokazpanel(VBox paneldopokazania) {
        dodajpanel2.setVisible(false);
        dodajpanel2.setManaged(false);
        dodajpanel3.setVisible(false);
        dodajpanel3.setManaged(false);
        dodajpanel4.setVisible(false);
        dodajpanel4.setManaged(false);
        dodajpanel5.setVisible(false);
        dodajpanel5.setManaged(false);
        paneldopokazania.setVisible(true);
        paneldopokazania.setManaged(true);
    }

    public void dodajsrodki() {
        pokazpanel(dodajpanel2);
    }

    public void wplacsrodki() {
        String wplata = wplataField.getText();
        double wplata2;
        try {
            wplata2 = Double.parseDouble(wplata);
            if (wplata2 <= 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Musisz wplacic minimum 1 PLN!");
                alert.showAndWait();
                return;
            }
            UserDAO userDAO = new UserDAO();
            userDAO.depozyt(loginuzytkownika, wplata2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Wplata udana!");
            alert.showAndWait();
            wyswietlsaldo();
            wplataField.clear();
            ukryjpanel();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Zly format kwoty!");
            alert.showAndWait();
        }
    }

    public void wyswietlogin(String login) {
        this.loginuzytkownika = login;
        loginLabel.setText(login);
        try {
            wyswietlsaldo();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad wczytania salda!");
            alert.showAndWait();
            saldoLabel.setText("Blad wczytania salda!");
        }
    }

    public void wyswietlsaldo() throws SQLException {
        UserDAO userDAO = new UserDAO();
        double saldo = userDAO.Wyswietlsaldo(loginuzytkownika);
        saldoLabel.setText(String.format("%.2f", saldo));
    }

    public void kupprodukt() {
        pokazpanel(dodajpanel3);
        pokazprodukty();
    }

    public void pokazzamowieniapanel() {
        pokazpanel(dodajpanel5);
        pokazzamowieniaklienta();
    }

    public void pokazprodukty() {
        try {
            UserDAO userDAO = new UserDAO();
            List<Produkt> produkty = userDAO.pokazProdukty();
            ObservableList<Produkt> produkts = FXCollections.observableArrayList(produkty);
            widok.setItems(produkts);
            widok.setEditable(true);
            widokkoszyka.setEditable(true);
            zaznaczField.setEditable(true);
            usuncheckbox.setEditable(true);
            zaznaczField.setCellValueFactory(cellData -> cellData.getValue().zaznaczonyProperty());zaznaczField.setCellValueFactory(cellData -> cellData.getValue().zaznaczonyProperty());
            zaznaczField.setCellFactory(CheckBoxTableCell.forTableColumn(zaznaczField));
            usuncheckbox.setCellValueFactory(cellData -> cellData.getValue().zaznaczonydousunieciaProperty());
            usuncheckbox.setCellFactory(CheckBoxTableCell.forTableColumn(usuncheckbox));
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

    public void wyswietlkoszyk() {
        ObservableList<Produkt> produktykoszyk = Wyswietlprodukty();
        koszykiloscproduktudozakupuField.setCellValueFactory(new PropertyValueFactory<>("iloscdozakupu"));
        koszyknazwaproduktuField.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        koszykcenaproduktuField.setCellValueFactory(new PropertyValueFactory<>("cena"));
        koszykiloscproduktuField.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        koszykiloscproduktudozakupuField.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        koszykiloscproduktudozakupuField.setOnEditCommit(event -> {

            Produkt produkt = event.getRowValue();
            int newValue = event.getNewValue();

            if (produkt == null) {
                return;
            }
            if (newValue < 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Musisz zamowic minimum 1 sztuke tego produktu!");
                alert.showAndWait();
                widokkoszyka.refresh();
                return;
            }
            if (newValue > produkt.getIlosc()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Nie mozesz zamowic wiecej niz dostepna ilosc!");
                alert.showAndWait();
                widokkoszyka.refresh();
                return;
            }
            produkt.setIloscdozakupu(newValue);
            zaaktualizujcene();
            widokkoszyka.refresh();
        });
        widokkoszyka.setEditable(true);
        widokkoszyka.setItems(produktykoszyk);
        zaaktualizujcene();
        pokazpanel(dodajpanel4);
    }

    public void zakup() {
        ObservableList<Produkt> produktydozakupu = widokkoszyka.getItems();
        if (produktydozakupu.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Twoj koszyk jest pusty!");
            alert.showAndWait();
            return;
        }
        double cenacalkowita = 0;
        for (Produkt produkt : produktydozakupu) {
            cenacalkowita += produkt.getCena() * produkt.getIloscdozakupu();
        }
        try {
            UserDAO userDAO = new UserDAO();
            double saldo = userDAO.Wyswietlsaldo(loginuzytkownika);
            if (saldo < cenacalkowita) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Brak wystarczajacych srodkow na koncie!!");
                alert.showAndWait();
                return;
            }
            int id_klienta = userDAO.znajdzuzytkownikapologinie(loginuzytkownika);
            Date dzis = new Date(System.currentTimeMillis());
            userDAO.dodajzamowienie(id_klienta, dzis, "W REALIZACJI", cenacalkowita);
            userDAO.zakup(loginuzytkownika, cenacalkowita);
            for (Produkt produkt : produktydozakupu) {
                if (produkt.getIloscdozakupu() == produkt.getIlosc()) {
                    userDAO.usunprodukt(produkt.getId_produktu());
                } else {
                    int nowailoscproduktu = produkt.getIlosc() - produkt.getIloscdozakupu();
                    userDAO.zaaktualizujiloscproduktu(produkt.getId_produktu(), nowailoscproduktu);
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Zakup udany!");
            alert.showAndWait();
            wyswietlsaldo();
            pokazprodukty();
            widokkoszyka.getItems().clear();
            cenacalkowitaField.clear();
            ukryjpanel();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Problem z zakupem!");
            alert.showAndWait();
        }
    }

    public void usunzkoszyka() {
        ObservableList<Produkt> aktualneprodukty = widokkoszyka.getItems();
        ObservableList<Produkt> produktydousuniecia = FXCollections.observableArrayList();
        for (Produkt produkt : aktualneprodukty) {
            if (produkt.isZaznaczonydousuniecia()) {
                produktydousuniecia.add(produkt);
            }
        }
            if (produktydousuniecia.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Zaznacz produkt ktory chcesz usunac z koszyka!");
                alert.showAndWait();
                return;
            }

        aktualneprodukty.removeAll(produktydousuniecia);
        zaaktualizujcene();
    }

    public void zaaktualizujcene() {
        double suma = 0;
        for (Produkt produkt : widokkoszyka.getItems()) {
            suma += produkt.getCena() * produkt.getIloscdozakupu();
        }
        cenacalkowitaField.setText(String.format("%.2f", suma));
    }

    public ObservableList<Produkt> Wyswietlprodukty() {
        ObservableList<Produkt> wybraneprodukty = FXCollections.observableArrayList();
        for (Produkt produkt : widok.getItems()) {
            if (produkt.isZaznaczony()) {
                produkt.setZaznaczonydousuniecia(false);
                if (produkt.getIloscdozakupu() <= 0) {
                    produkt.setIloscdozakupu(1);
                }
                wybraneprodukty.add(produkt);
            }
        }
        return wybraneprodukty;
    }

    public void Wstecz() {

        for (Produkt produkt : widok.getItems()) {
            produkt.setZaznaczony(false);
        }

        pokazpanel(dodajpanel3);
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

    public void pokazzamowieniaklienta() {
        try {
            UserDAO userDAO = new UserDAO();
            List<Zamowienie> zamowienia = userDAO.pokazzamowieniaklienta(loginuzytkownika);
            ObservableList<Zamowienie> zamowienia2 = FXCollections.observableArrayList(zamowienia);
            widokzamowien.setItems(zamowienia2);
            statusField.setCellValueFactory(new PropertyValueFactory<>("status_zamowienia"));
            datazamowieniaField.setCellValueFactory(new PropertyValueFactory<>("data_zamowienia"));
            cenazamowieniaField.setCellValueFactory(new PropertyValueFactory<>("cena_zamowienia"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad przy wczytywaniu zamowien!");
            alert.showAndWait();
        }
    }

    public void szukanieproduktow() {
        UserDAO userDAO = new UserDAO();
        String filtrowanie = szukanieField.getText();
        try {
            List<Produkt> wyniki = userDAO.szukajProdukt(filtrowanie);
            ObservableList<Produkt> produkts = FXCollections.observableArrayList(wyniki);
            for (Produkt p : produkts) {
                p.setZaznaczony(zaznaczoneProdukty.contains(p.getId_produktu()));
            }
            widok.setItems(produkts);
            ListenerDoZaznaczen(produkts);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad przy filtrowaniu produktow!");
            alert.showAndWait();
        }
    }

    private void ListenerDoZaznaczen(ObservableList<Produkt> produkty) {
        for (Produkt produkt : produkty) {
            produkt.zaznaczonyProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    zaznaczoneProdukty.add(produkt.getId_produktu());
                } else {
                    zaznaczoneProdukty.remove(produkt.getId_produktu());
                }
            }
            );
        }
    }
    }







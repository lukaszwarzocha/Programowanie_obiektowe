package com.example.projekcik;

import com.example.projekcik.DB.UserDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class LoginController  {

    public TextField loginField;
    public PasswordField passwordField;

    @FXML
    protected void Login() {
        String loginuzytkownika = loginField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();
        if (login.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Musisz wypelnic wszystkie pola!");
            alert.showAndWait();
            return;
        }
        try {
            UserDAO userDAO = new UserDAO();
            if (userDAO.ZalogujAdministrator(login, password)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminpanel.fxml"));
                logowanie(fxmlLoader);
                AdminPanelController adminpanel = fxmlLoader.getController();
                adminpanel.wyswietlogin(loginuzytkownika);
            } else if (userDAO.ZalogujUzytkownik(login, password)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userpanel.fxml"));
                logowanie(fxmlLoader);
                UserPanelController userpanel = fxmlLoader.getController();
                userpanel.wyswietlogin(loginuzytkownika);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Podales nieprawidlowy login lub haslo!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad podczas logowania!");
            alert.showAndWait();
        }
    }

    private void logowanie(FXMLLoader fxmlLoader) throws IOException {
        Scene scene = new Scene(fxmlLoader.load(), 595, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Stage panelglowny = (Stage) loginField.getScene().getWindow();
        panelglowny.setScene(scene);
        panelglowny.setTitle("Sklep ogrodowy");
        panelglowny.sizeToScene();
        panelglowny.show();
    }

    @FXML
    protected void Register() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 340);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Stage stage = (Stage) loginField.getScene().getWindow();
        stage.setTitle("Sklep ogrodowy");
        stage.setScene(scene);
        stage.show();
    }
}
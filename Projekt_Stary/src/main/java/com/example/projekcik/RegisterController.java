package com.example.projekcik;

import javafx.stage.Stage;
import com.example.projekcik.DB.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterController extends LoginController {

    public TextField usernameField;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public TextField addressField;
    public TextField ageField;
    public PasswordField passwordField;

    public void WyczyscPola() {
        usernameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        addressField.clear();
        ageField.clear();
        addressField.clear();
    }

    @FXML
    protected void Zalozkonto() throws SQLException {
        UserDAO userDAO = new UserDAO();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String ageText = ageField.getText();

        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                firstName == null || firstName.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                address == null || address.trim().isEmpty() ||
                ageText == null || ageText.trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Musisz wypelnic wszystkie pola!");
            alert.showAndWait();
            return;
        }
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Wiek musi byc liczba!");
            alert.showAndWait();
            return;
        }
        if (age < 18) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Musisz miec co najmniej 18 lat!");
            alert.showAndWait();
            return;
        }
        if (userDAO.UzytkownikIstnieje(username)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Uzytkownik o takim loginie juz istnieje!");
            alert.showAndWait();
            return;
        }
        if (userDAO.EmailIstnieje(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Taki email jest juz przypisany do innego konta!");
            alert.showAndWait();
            return;
        }
        try {
            userDAO.dodajUzytkownika(username, password, firstName, lastName, age, email, address);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Rejestracja zakonczona sukcesem!");
            alert.showAndWait();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 340);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            Stage login = new Stage();
            login.setTitle("Sklep ogrodowy");
            login.setScene(scene);
            login.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Blad przy rejestracji! Rejestracja nie powiodla sie!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void Mamkonto() throws IOException {
        Stage CurrentStage = (Stage) usernameField.getScene().getWindow();
        CurrentStage.close();
        WyczyscPola();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 260, 310);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Stage login = new Stage();
        login.setTitle("Sklep ogrodowy");
        login.setScene(scene);
        login.show();
    }
}


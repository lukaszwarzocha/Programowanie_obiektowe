module com.example.projekcik {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens com.example.projekcik to javafx.fxml;
    exports com.example.projekcik;

    exports com.example.projekcik.DB;
    opens com.example.projekcik.DB to javafx.fxml;
}

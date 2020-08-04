module org.allvens {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.prefs;

    opens org.allvens to javafx.fxml;
    opens org.allvens.installer to javafx.fxml;
    opens org.allvens.controller to javafx.fxml;
    exports org.allvens;
}
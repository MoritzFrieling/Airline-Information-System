module f.guilayer {
    requires javafx.controls;
    requires javafx.fxml;

    opens f.guilayer to javafx.fxml;
    exports f.guilayer;
}

module gui_module {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.base;
    requires businesslogic_module;
    requires java.desktop;
    requires com.esri.arcgisruntime;

    opens gui to javafx.fxml;
    
    exports gui;
}

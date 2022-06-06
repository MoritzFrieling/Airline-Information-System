package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class MapViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    @FXML
    AnchorPane anchorPane;




    public MapViewController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

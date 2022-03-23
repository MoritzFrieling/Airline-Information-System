package gui;

import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * Just for demo purposes, Controller of other view (secondary.fxml).
 * 
 * @author Informatics Fontys Venlo
 */
class SecondaryController {
    
    @FXML
    private Button addRouteButton;

    
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void goAddRoute() {
        sceneManagerSupplier.get().changeScene("airportView");
    }
    
       
}
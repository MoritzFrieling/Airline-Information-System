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
    private Button addAirportButton;
    private Button addPlaneButton;
    private Button addRouteButton;
    private Button addFlightButton;
    private Button dashboardButton;
    private Button logoutButton;

    
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void goAddAirport() {
        sceneManagerSupplier.get().changeScene("airportView");
    }

    @FXML
    private void goAddPlane(){ sceneManagerSupplier.get().changeScene("addPlaneView"); 
    }
    
    @FXML
    private void goAddRoute(){ sceneManagerSupplier.get().changeScene("addRouteView"); 
    }

    @FXML
    private void goAddFlight(){ sceneManagerSupplier.get().changeScene("addFlightView");
    }
    
       
}
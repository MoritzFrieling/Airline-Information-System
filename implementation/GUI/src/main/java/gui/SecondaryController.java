package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.function.Supplier;


/**
 * Just for demo purposes, Controller of other view (secondary.fxml).
 * 
 * @author Informatics Fontys Venlo
 */
class SecondaryController {
    @FXML
    public Button addPlaneModelButton;
    @FXML
    private Button addAirportButton;
    private Button addPlaneButton;
    @FXML
    private Button addRouteButton;
    private Button addFlightButton;
    @FXML
    private Button dashboardButton;
    @FXML
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
    private void goFlightOptions(){ sceneManagerSupplier.get().changeScene("flightOptionsView");
    }

    @FXML
    private void logOut(){sceneManagerSupplier.get().changeScene("logInView");}

    @FXML
    private void toRegisterAccount(){sceneManagerSupplier.get().changeScene("accountRegistrationView");}

    @FXML
    private void goAddPlaneModel(){ sceneManagerSupplier.get().changeScene("addPlaneModelView");}
    
       
}
package gui;

import businesslogic.AirportManager;
import datarecords.AirportData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * FXML Customer Controller class.
 * The controller class contains GUI-logic (no business logic!). It reacts on
 * GUI events like button clicks. It triggers the BusinessLogic layer
 * to do the real work. Furthermore the controller will trigger navigation
 * and update the GUI.
 *
 * @author Informatics Fontys Venlo
 */
class AirportController implements Initializable {

    @FXML
    private TextField airportName;
    @FXML
    private TextField abbreviationName;
    @FXML
    private TextField cityName;
    @FXML
    private TextField countryName;
    @FXML
    private Button saveButton;
    @FXML
    private Button toSecondaryButton;
    @FXML
    private Label result;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final AirportManager airportManager;

    public AirportController(Supplier<SceneManager> sceneManagerSupplier, AirportManager airportManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.airportManager = airportManager;
    }

    @FXML
    private void toSecondary() {
        
        sceneManagerSupplier.get().changeScene("secondary");
    }

    @FXML
    private void storeAirport() {

        AirportData airportData = new AirportData( airportName.getText(), abbreviationName.getText(), cityName.getText(), countryName.getText());

        AirportData addedAirport = airportManager.add(airportData);
     
        result.setText("AIRPORT ADDED \n \n" + addedAirport.toString() );
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

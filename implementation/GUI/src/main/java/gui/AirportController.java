package gui;

import businesslogic.AirportManager;
import businesslogic.CoordinateManager;
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
    private TextField countryName;
    @FXML
    private TextField coordinate;
    @FXML
    private Button saveButton;
    @FXML
    private Button toSecondaryButton;
    @FXML
    private Label result;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final AirportManager airportManager;
    private final CoordinateManager coordinateManager;

    public AirportController(Supplier<SceneManager> sceneManagerSupplier, AirportManager airportManager, CoordinateManager coordinateManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.airportManager = airportManager;
        this.coordinateManager = coordinateManager;
    }

    @FXML
    private void toSecondary() {
        
        sceneManagerSupplier.get().changeScene("secondary");
    }

    @FXML
    private void storeAirport() throws Exception {

        AirportData airportData = new AirportData(
                airportName.getText(),
                abbreviationName.getText(),
                countryName.getText(),
                coordinateManager.add(coordinate.getText())
                );

        boolean addedAirport = airportManager.add(airportData);
     
        result.setText("Adding the airport worked:  \n \n" + addedAirport );
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

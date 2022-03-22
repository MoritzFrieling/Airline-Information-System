package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import businesslogic.AirportManager;
import datarecords.AirportData;
import datarecords.AirportData;
import java.time.LocalDate;
import java.util.function.Consumer;
import javafx.scene.control.Label;

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
        Consumer<SecondaryController> consumer
                = (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene("secondary", consumer);
    }

    @FXML
    private void storeAirport() {

        AirportData airportData = new AirportData(0, airportName.getText(), abbreviationName.getText(), cityName.getText());

        AirportData addedAirport = airportManager.add(airportData);
     
        result.setText("Airport added: " + addedAirport.toString() );
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

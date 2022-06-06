package gui;


import businesslogic.AirportManager;
import businesslogic.CoordinateManager;
import datarecords.AirportData;
import datarecords.CoordinateData;
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
    private TextField cityName;
    @FXML
    private Button saveButton;
    @FXML
    private Button toSecondaryButton;
    @FXML
    private Button checkAirports;
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

        boolean valid = true;
        String a = airportName.getText();
        String b = abbreviationName.getText();
        String c = coordinate.getText();
        String d = countryName.getText();
        String e = cityName.getText();

        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty()){
            result.setText("Please check input!");
            valid = false;
        }

        if (valid) {
            CoordinateData cdata = coordinateManager.add(c);
            String f = airportManager.checkTimezone(cdata.getLongitude());
            AirportData airportData = new AirportData(a, b, d, cdata, e, f);

            if (!coordinateManager.check(cdata)) {
                result.setText("Coordinate out of possible range!");
                valid = false;
            }

            if (airportManager.checkNull(airportData)) {
                result.setText("Please check the input!");
                valid = false;
            }

            if (valid) {
                boolean addedAirport = airportManager.add(airportData);

                if (addedAirport) {
                    result.setText("Airport successfully added to DB!");
                } else result.setText("Couldn't add Airport, please Check the data!");
            }
        }
    }

    @FXML
    private void checkAirports(){
        sceneManagerSupplier.get().changeScene("mapView");
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

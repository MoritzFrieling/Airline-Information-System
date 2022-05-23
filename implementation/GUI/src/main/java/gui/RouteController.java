package gui;

import businesslogic.AirportManager;
import businesslogic.Coordinate;
import businesslogic.RouteManager;
import datarecords.AirportData;
import datarecords.CoordinateData;
import datarecords.RouteData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;



/**
 * FXML Customer Controller class. The controller class contains GUI-logic (no
 * business logic!). It reacts on GUI events like button clicks. It triggers the
 * BusinessLogic layer to do the real work. Furthermore the controller will
 * trigger navigation and update the GUI.
 *
 * @author Informatics Fontys Venlo
 */
class RouteController implements Initializable {

    @FXML
    private ComboBox modelDropDownOrigin;
    @FXML
    private ComboBox modelDropDownDestination;
    @FXML
    private Label result;
    @FXML
    private Label l;


    private final Supplier<SceneManager> sceneManagerSupplier;
    private final RouteManager routeManager;
    private final AirportManager airportManager;

    public RouteController(Supplier<SceneManager> sceneManagerSupplier, RouteManager routeManager, AirportManager airportManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeManager = routeManager;
        this.airportManager = airportManager;
    }

    @FXML
    private void toSecondary() {

        sceneManagerSupplier.get().changeScene("secondary");
    }
    

    @FXML
    private void storeRoute() {

        RouteData routeData = createRoute();
        
        boolean addedRoute = routeManager.add(routeData);

        result.setText("Adding route worked: " + addedRoute);

    }


    private RouteData createRoute() {
        if (modelDropDownOrigin.getSelectionModel().isSelected(1) && modelDropDownDestination.getSelectionModel().isSelected(1)) {
            AirportData origin = new AirportData( "Berlin Flughafen", "BRLN", "Germany", new CoordinateData(40.446,-79.982), "Berlin");
            AirportData destination = new AirportData( "New York Airport", "NY", "USA", new CoordinateData(30.456,-20.345), "New York");
            return new RouteData(origin, destination,
                    new Coordinate( origin.getCoordinateData() ).rangeTo( new Coordinate( destination.getCoordinateData() ) )
            );
        } else {
            return null;
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelDropDownOrigin.getItems().addAll();
        modelDropDownDestination.getItems().addAll("-- select destination --","New York");
        modelDropDownOrigin.getSelectionModel().select("-- select origin --");
        modelDropDownDestination.getSelectionModel().select("-- select destination --");

    }

}

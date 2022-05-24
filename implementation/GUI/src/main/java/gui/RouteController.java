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
    private ComboBox<String> modelDropDownOrigin;
    @FXML
    private ComboBox<String> modelDropDownDestination;
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

        String OrStr = modelDropDownOrigin.getSelectionModel().getSelectedItem();
        String[] origin = OrStr.split(",");

        String DeStr = modelDropDownDestination.getSelectionModel().getSelectedItem();
        String[] destination = DeStr.split(",");

        AirportData oData = airportManager.getAirport(origin[0]);

        AirportData dData = airportManager.getAirport(destination[0]);

        RouteData data = new RouteData(oData,dData,new Coordinate(oData.getCoordinateData()).rangeTo(new Coordinate(dData.getCoordinateData())));
        
        boolean addedRoute = routeManager.add(data);

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

    @FXML
    private void updateDestination(){

            modelDropDownDestination.getItems().remove(modelDropDownOrigin.getSelectionModel().getSelectedItem());

            if (modelDropDownDestination.getItems().size() < 3){

                modelDropDownDestination.getItems().clear();

                modelDropDownDestination.getItems().addAll(airportManager.getAllAirports());


            }

    }

    @FXML
    private void updateOrigin(){

        modelDropDownOrigin.getItems().remove(modelDropDownDestination.getSelectionModel().getSelectedItem());

        if (modelDropDownOrigin.getItems().size() < 3){

            modelDropDownOrigin.getItems().clear();

            modelDropDownOrigin.getItems().addAll(airportManager.getAllAirports());
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url url
     * @param rb resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelDropDownOrigin.getItems().addAll(airportManager.getAllAirports());
        modelDropDownDestination.getItems().addAll(airportManager.getAllAirports());


    }

}

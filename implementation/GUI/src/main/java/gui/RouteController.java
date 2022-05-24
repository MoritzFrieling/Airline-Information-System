package gui;

import businesslogic.AirportManager;
import businesslogic.Coordinate;
import businesslogic.RouteManager;
import datarecords.AirportData;
import datarecords.RouteData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private void updateDestination(){

        ArrayList<String> itms = airportManager.getAllAirports();


        if (modelDropDownDestination.getItems().size() == airportManager.getAllAirports().size()) {
            modelDropDownDestination.getItems().remove(modelDropDownOrigin.getSelectionModel().getSelectedItem());
        }else if (modelDropDownDestination.getItems().size() != itms.size()){
            String str = modelDropDownDestination.getSelectionModel().getSelectedItem();
            String rmv = modelDropDownOrigin.getSelectionModel().getSelectedItem();
            modelDropDownDestination.getSelectionModel().clearSelection();
            modelDropDownDestination.getItems().clear();

            modelDropDownDestination.getItems().addAll(airportManager.getAllAirports());
            modelDropDownDestination.getItems().remove(rmv);
            modelDropDownOrigin.getSelectionModel().select(str);
        }

    }

    @FXML
    private void updateOrigin(){

        if (modelDropDownOrigin.getItems().size() == airportManager.getAllAirports().size()){
            modelDropDownOrigin.getItems().remove(modelDropDownDestination.getSelectionModel().getSelectedItem());
        }else if (modelDropDownOrigin.getItems().size() != airportManager.getAllAirports().size()){
            String str = modelDropDownOrigin.getSelectionModel().getSelectedItem();
            String rmv = modelDropDownDestination.getSelectionModel().getSelectedItem();
            modelDropDownOrigin.getSelectionModel().clearSelection();
            modelDropDownOrigin.getItems().clear();

            modelDropDownOrigin.getItems().addAll(airportManager.getAllAirports());
            modelDropDownOrigin.getItems().remove(rmv);
            modelDropDownDestination.getSelectionModel().select(str);
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

package gui;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import businesslogic.RouteManager;

import datarecords.RouteData;
import datarecords.AirportData;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;



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
    private Slider distanceSlider;
    @FXML
    private Label result;
    @FXML
    private Label l;


    private final Supplier<SceneManager> sceneManagerSupplier;
    private final RouteManager routeManager;

    public RouteController(Supplier<SceneManager> sceneManagerSupplier, RouteManager routeManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeManager = routeManager;
    }

    @FXML
    private void toSecondary() {

        sceneManagerSupplier.get().changeScene("secondary");
    }
    

    @FXML
    private void storeRoute() {

        RouteData routeData = createRoute();
        
        RouteData addedRoute = routeManager.add(routeData);

        result.setText("Route added: " + addedRoute.toString());

    }


    private RouteData createRoute() {
        if (modelDropDownOrigin.getSelectionModel().isSelected(1) && modelDropDownDestination.getSelectionModel().isSelected(1)) {
            AirportData origin = new AirportData(0, "Berlin Flughafen", "BRLN", "Berlin", "Germany");
            AirportData destination = new AirportData(1, "New York Airport", "NY", "New York", "USA");
            return new RouteData(origin, destination, (int)distanceSlider.getValue());
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
        modelDropDownOrigin.getItems().addAll("-- select origin --","Berlin");
        modelDropDownDestination.getItems().addAll("-- select destination --","New York");
        modelDropDownOrigin.getSelectionModel().select("-- select origin --");
        modelDropDownDestination.getSelectionModel().select("-- select destination --");


        distanceSlider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue <? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {

                        l.setText("distance: " + newValue.intValue());
                    }
                });
    }

}

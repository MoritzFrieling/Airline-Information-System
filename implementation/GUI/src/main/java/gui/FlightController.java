package gui;

import businesslogic.FlightManager;
import datarecords.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.function.Supplier;

class FlightController implements Initializable {
    @FXML
    public ComboBox modelDropDownOrigin;
    @FXML
    public ComboBox modelDropDownDestination;
    @FXML
    public DatePicker datePickerDeparture;
    @FXML
    public DatePicker datePickerArrival;
    @FXML
    public ComboBox modelDropDownPlane;
    @FXML
    private Label result;


    private final Supplier<SceneManager> sceneManagerSupplier;
    private final FlightManager flightManager;

    public FlightController(Supplier<SceneManager> sceneManagerSupplier, FlightManager flightManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.flightManager = flightManager;
    }

    @FXML
    private void toSecondary() {
        sceneManagerSupplier.get().changeScene("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelDropDownOrigin.getItems().addAll("-- select origin --","Berlin");
        modelDropDownDestination.getItems().addAll("-- select destination --","New York");
        modelDropDownOrigin.getSelectionModel().select("-- select origin --");
        modelDropDownDestination.getSelectionModel().select("-- select destination --");

        modelDropDownPlane.getItems().addAll("-- select plane --","ATR 42","ATR 72","Airbus A300");



    }

    @FXML
    private void storeFlight() {

        FlightData flightData = createFlight();

        flightManager.add(flightData);

        result.setText("Flight added: " + flightData.toString());

    }

    private FlightData createFlight() {
        if (modelDropDownOrigin.getSelectionModel().isSelected(1) && modelDropDownDestination.getSelectionModel().isSelected(1) && modelDropDownPlane.getSelectionModel().isSelected(1) &&modelDropDownDestination.getValue() !=null && modelDropDownOrigin.getValue()!= null) {
            AirportData origin = new AirportData(0, "Berlin Flughafen", "BRLN", "Berlin", "Germany");
            AirportData destination = new AirportData(1, "New York Airport", "NY", "New York", "USA");
            LocalDateTime arrival = datePickerArrival.getValue().atStartOfDay();
            LocalDateTime departure = datePickerDeparture.getValue().atTime(3,45);



            //LocalDateTime.now() just for test purpose. Needs to retrieve real time picked!!
            return new FlightData(origin, destination, departure, LocalDateTime.now());
        } else {
            return null;
        }
    }

}

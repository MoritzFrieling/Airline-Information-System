package gui;

import businesslogic.FlightManager;
import datarecords.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public TextField durationMinutes;
    @FXML
    public Label testText;
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

        modelDropDownPlane.getItems().addAll("-- select plane --","ATR 42-300","ATR 72","Airbus A300");



    }

    @FXML
    private void storeFlight() {

        FlightData flightData = createFlight();

        flightManager.add(flightData);

        result.setText("Flight added: " + flightData.toString());

    }

    private FlightData createFlight() {
        if (modelDropDownOrigin.getSelectionModel().isSelected(1) && modelDropDownDestination.getSelectionModel().isSelected(1) && modelDropDownPlane.getSelectionModel().isSelected(1)) {

            AirportData origin = new AirportData(0, "Berlin Flughafen", "BRLN", "Berlin", "Germany");
            AirportData destination = new AirportData(1, "New York Airport", "NY", "New York", "USA");

            PlaneData plane = new PlaneData("9",new PlaneModelData("Avions de Transport Regional","42-300",50,1150,4950));


            LocalDate departureDate = datePickerDeparture.getValue();
            LocalTime departureTime = LocalTime.of(13,50);
            LocalDateTime departureDateTime = departureDate.atTime(departureTime);
            LocalDateTime arrivalDateTime = departureDateTime.plusMinutes(Integer.valueOf(durationMinutes.getText()));



            return new FlightData(origin, destination, departureDateTime, arrivalDateTime, plane);
        } else {
            result.setText("You picked a not yet implemented plane or City or you didnt fill in minutes / date!\nPlease ensure picking the first entry!");
            return null;
        }
    }
    @FXML
    private void goFlightOptions(){ sceneManagerSupplier.get().changeScene("flightOptionsView");
    }
}

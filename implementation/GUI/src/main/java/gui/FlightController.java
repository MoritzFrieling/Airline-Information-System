package gui;

import businesslogic.Coordinate;
import businesslogic.FlightManager;
import datarecords.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
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
    public ComboBox modelDropDownPlane;
    @FXML
    public TextField durationMinutes;
    @FXML
    public TextField departureTime;
    @FXML
    public TextField defaultFlightPrice;
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

        result.setText("Flight added:\n" + flightData.toString());

    }

    private FlightData createFlight() {
        if (modelDropDownOrigin.getSelectionModel().isSelected(1) && modelDropDownDestination.getSelectionModel().isSelected(1) && modelDropDownPlane.getSelectionModel().isSelected(1) && !departureTime.getText().isEmpty() && !durationMinutes.getText().isEmpty()) {

            AirportData origin = new AirportData( "Berlin Flughafen", "BRLN", "Germany", new CoordinateData(40.446,-79.982));
            AirportData destination = new AirportData( "New York Airport", "NY", "USA", new CoordinateData(30.456,-20.345));
            RouteData route = new RouteData(origin, destination,
                    new Coordinate( origin.getCoordinateData() ).rangeTo( new Coordinate( destination.getCoordinateData() ) )
            );

            PlaneData plane = new PlaneData("9",new PlaneModelData("Avions de Transport Regional","42-300",50,1150,4950, 950));
            String[] split = departureTime.getText().split(":");

            LocalDateTime departureDateTime = datePickerDeparture.getValue().atTime(LocalTime.of(Integer.valueOf(split[0]),Integer.valueOf(split[1])));
            LocalDateTime arrivalDateTime = departureDateTime.plusMinutes(Integer.valueOf(durationMinutes.getText()));

            int price = Integer.valueOf(defaultFlightPrice.getText());

            return new FlightData(route, departureDateTime, arrivalDateTime, plane, price);
        } else {
            result.setText("Please ensure picking the first entry for plane, origin and destination!\nThe format for departure time is 'hh:mm' -> '14:30'\nPlease fill out every field.");
            return null;
        }
    }
    @FXML
    private void goFlightOptions(){ sceneManagerSupplier.get().changeScene("flightOptionsView");
    }
}

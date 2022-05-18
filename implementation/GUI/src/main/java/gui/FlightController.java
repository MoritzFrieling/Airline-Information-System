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
    public ComboBox modelDropDownRoute;
    @FXML
    public DatePicker datePickerDeparture;
    @FXML
    public ComboBox modelDropDownPlane;
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
        //Drop down for the available routes
        modelDropDownRoute.getItems().addAll("Berlin -> New York");
        modelDropDownRoute.getSelectionModel().select("-- Select Route --");

        //Drop down for the available planes
        modelDropDownPlane.getItems().addAll("ATR 42-300","ATR 72","Airbus A300");
        modelDropDownPlane.getSelectionModel().select("-- Select Plane --");

    }

    @FXML
    private void storeFlight() {
        FlightData flightData = createFlight();
        flightManager.add(flightData);
        result.setText("Flight added:\n" + flightData.toString());
    }

    private FlightData createFlight() {
        if (modelDropDownRoute.getSelectionModel().isSelected(0) && modelDropDownPlane.getSelectionModel().isSelected(0) && !departureTime.getText().isEmpty()) {

            //Origin and destination for the route
            AirportData origin = new AirportData( "Berlin Flughafen", "BRLN", "Germany", new CoordinateData(40.446,-79.982));
            AirportData destination = new AirportData( "New York Airport", "NY", "USA", new CoordinateData(30.456,-20.345));

            //the route of the flight, distance is calculated with the help of the coordinates
            RouteData route = new RouteData(origin, destination,
                    new Coordinate( origin.getCoordinateData() ).rangeTo(new Coordinate( destination.getCoordinateData()))
            );


            PlaneData plane = new PlaneData(new PlaneModelData("Avions de Transport Regional","42-300",50,1150,4950, 950), 30,14,6);

            //splits the departure time into hours and minutes
            String[] splitDepartureTime = departureTime.getText().split(":");

            //EST. Departure time
            LocalDateTime departureDateTime = datePickerDeparture.getValue().atTime(LocalTime.of(Integer.parseInt(splitDepartureTime[0]),Integer.parseInt(splitDepartureTime[1])));

            //EST. Arrival time -- Duration should be retrieved by the flight speed and distance! 
            int duration = 120;
            LocalDateTime arrivalDateTime = departureDateTime.plusMinutes(duration);

            //default flight price
            int price = Integer.parseInt(defaultFlightPrice.getText());

            //returns the finished flight with:
            //route, departure time, arrival time, plane, price
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

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
    public TextField seatClasses;
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
        modelDropDownRoute.getItems().addAll("-- select route --","Berlin -> New York");
        modelDropDownRoute.getSelectionModel().select("-- select origin --");

        //Drop down for the available planes
        modelDropDownPlane.getItems().addAll("-- select plane --","ATR 42-300","ATR 72","Airbus A300");
    }

    @FXML
    private void storeFlight() {
        FlightData flightData = createFlight();
        flightManager.add(flightData);
        result.setText("Flight added:\n" + flightData.toString());
    }

    private FlightData createFlight() {
        if (modelDropDownRoute.getSelectionModel().isSelected(1) && modelDropDownPlane.getSelectionModel().isSelected(1) && !departureTime.getText().isEmpty()) {

            //Origin and destination for the route
            AirportData origin = new AirportData( "Berlin Flughafen", "BRLN", "Germany", new CoordinateData(40.446,-79.982));
            AirportData destination = new AirportData( "New York Airport", "NY", "USA", new CoordinateData(30.456,-20.345));

            //the route of the flight, distance is calculated with the help of the coordinates
            RouteData route = new RouteData(origin, destination,
                    new Coordinate( origin.getCoordinateData() ).rangeTo(new Coordinate( destination.getCoordinateData()))
            );

            //plane for the flight
            PlaneData plane = new PlaneData("9",new PlaneModelData("Avions de Transport Regional","42-300",50,1150,4950));

            //splits the departure time into hours and minutes
            String[] splitDepartureTime = departureTime.getText().split(":");

            //EST. Departure time
            LocalDateTime departureDateTime = datePickerDeparture.getValue().atTime(LocalTime.of(Integer.valueOf(splitDepartureTime[0]),Integer.valueOf(splitDepartureTime[1])));

            //EST. Arrival time
            int duration = 120;
            LocalDateTime arrivalDateTime = departureDateTime.plusMinutes(duration);

            //default flight price
            int price = Integer.valueOf(defaultFlightPrice.getText());

            //splits the seats for each seatClass (economy, business, firstClass)


            //number of seats for each seatClass


            //returns the finished flight with:
            //route, departure time, arrival time, plane, price and number of seats for each class(economy, business, firstClass)
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

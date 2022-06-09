package gui;

import businesslogic.AirportManager;
import businesslogic.CoordinateManager;
import datarecords.AirportData;
import datarecords.CoordinateData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class AddAirportController implements Initializable {


    @FXML
    private Label result;
    @FXML
    private Label information;
    @FXML
    private ImageView imageView;
    @FXML
    private javafx.scene.control.TextField airportName;
    @FXML
    private javafx.scene.control.TextField abbreviationName;
    @FXML
    private javafx.scene.control.TextField countryName;
    @FXML
    private javafx.scene.control.TextField cityName;
    @FXML
    private javafx.scene.control.TextField coordinate;
    @FXML
    private AnchorPane imagePane;


    Supplier<SceneManager> supplier;
    AirportManager airportManager;
    CoordinateManager coordinateManager;

    public AddAirportController(Supplier<SceneManager> supplier, AirportManager am, CoordinateManager cm) {
        this.supplier = supplier;
        this.airportManager = am;
        this.coordinateManager = cm;

    }


    @FXML
    private void back(){
        supplier.get().changeScene("secondary");
    }

    @FXML
    private void storeAirport(){

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

        // PRC Lesson MAPS
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
                boolean addedAirport = false;
                try {
                    addedAirport = airportManager.add(airportData);
                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                }

                if (addedAirport) {
                    result.setText("Airport successfully added to DB!");
                } else result.setText("Couldn't add Airport, please Check the data!");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        double modifierY = (imageView.getImage().getHeight() / 180) + imageView.getImage().getHeight() / 2;
        double modifierX = (imageView.getImage().getWidth() / 360) + imageView.getImage().getWidth() / 2;

        Circle spot = new Circle(10);
        spot.setFill(Color.RED);
        spot.setCenterX(10);
        spot.setCenterY(10);

        spot.setLayoutX(10*modifierX);
        spot.setLayoutY(10*modifierY);

        imagePane.getChildren().add(spot);

    }
}

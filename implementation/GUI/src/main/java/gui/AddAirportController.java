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
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class AddAirportController implements Initializable {


    @FXML
    private Label result;
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
    @FXML
    private Label information;


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
                    setCircle();
                    result.setText("Airport successfully added to DB!");
                    information.setText("Last Airport Added: \n" + airportData);
                } else result.setText("Couldn't add Airport, please Check the data!");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        supplier.get().getScene().getWindow().setWidth(910);
        supplier.get().getScene().getWindow().setHeight(625);
       setCircle();

    }

    private void setCircle( ){
        for (int i = 0; airportManager.getAllAirportData().size() > i; i++) {
            Circle c = new Circle(2);

            CoordinateData data = airportManager.getAllAirportData().remove(i).getCoordinateData();

            double x = data.getLongitude();
            double y = data.getLatitude();
            c.setLayoutY(adaptLatitude(y));
            c.setLayoutX(adaptLongitude(x));
            System.out.println("Latitude:" + y + " Longitude:" + x);
            imagePane.getChildren().add(c);
        }
    }


    /**
     * works only if preserveRatio == true
     * @param x Longitude
     * @return x coordinate for the placement on the image
     */
    private double adaptLongitude(double x){
        double aspectRatio = imageView.getImage().getWidth() / imageView.getImage().getHeight();
        double realWidth = Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio);
        return (x+180) * (realWidth /360);
    }

    /**
     * works only if preserveRatio == true
     * @param y Longitude
     * @return y coordinate for the placement on the image
     */
    private double adaptLatitude(double y){
        double aspectRatio = imageView.getImage().getWidth() / imageView.getImage().getHeight();
        double realHeight = Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio);
        return (-y+90) * (realHeight / 180);
    }
}

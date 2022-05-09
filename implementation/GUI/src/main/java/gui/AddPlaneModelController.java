package gui;

import businesslogic.FlightManager;
import businesslogic.PlaneModelManager;
import datarecords.PlaneModelData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.function.Supplier;


public class AddPlaneModelController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final PlaneModelManager planeModelManager;
    @FXML
    public TextField manufacturer;
    @FXML
    public TextField maximumRange;
    @FXML
    public TextField modelNumber;
    @FXML
    public TextField weightCapacity;
    @FXML
    public TextField maximumSeats;

    public AddPlaneModelController(Supplier<SceneManager> sceneManagerSupplier, PlaneModelManager planeModelManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planeModelManager = planeModelManager;
    }

    @FXML
    private void toSecondary() {
        sceneManagerSupplier.get().changeScene("secondary");
    }

    @FXML
    private void storePlaneModel() throws Exception {
        PlaneModelData planeModelData = createPlaneModel();

        planeModelManager.add(planeModelData);
    }




    public PlaneModelData createPlaneModel() {
        String manufacturer = this.manufacturer.getText();
        String modelNumber = this.modelNumber.getText();
        int seats= Integer.parseInt(this.maximumSeats.getText());
        int range = Integer.parseInt(this.maximumRange.getText());
        int weightCapacity = Integer.parseInt(this.weightCapacity.getText());

        PlaneModelData planeModelData = new PlaneModelData(manufacturer, modelNumber, seats, range, weightCapacity);
        return planeModelData;
    }
}

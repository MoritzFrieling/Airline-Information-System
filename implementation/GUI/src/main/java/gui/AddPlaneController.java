package gui;

import businesslogic.Plane;
import businesslogic.PlaneManager;
import datarecords.PlaneData;
import datarecords.PlaneModelData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * FXML Customer Controller class.
 * The controller class contains GUI-logic (no business logic!). It reacts on
 * GUI events like button clicks. It triggers the BusinessLogic layer
 * to do the real work. Furthermore the controller will trigger navigation
 * and update the GUI.
 *
 * @author Informatics Fontys Venlo
 */
class AddPlaneController implements Initializable {
    @FXML
    public TextField economySeats;
    @FXML
    public TextField businessSeats;
    @FXML
    public TextField firstClassSeats;
    @FXML
    private ComboBox modelDropDown;
    @FXML
    private Button saveButton;
    @FXML
    private Button homeButton;
    @FXML
    private Label result;

    private List<PlaneModelData> planeModelList;


    private final Supplier<SceneManager> sceneManagerSupplier;
    private final PlaneManager planeManager;

    public AddPlaneController(Supplier<SceneManager> sceneManagerSupplier, PlaneManager planeManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planeManager = planeManager;

        try {
            this.planeModelList = planeManager.getAllPlaneModels();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void toSecondary() {

        sceneManagerSupplier.get().changeScene("secondary");
    }

    @FXML
    private void storePlane() throws Exception {

        PlaneData planeData = new PlaneData(setModel(), Integer.parseInt(economySeats.getText()), Integer.parseInt(businessSeats.getText()), Integer.parseInt(firstClassSeats.getText()));

        PlaneData addedPlane = planeManager.add(planeData);

//        result.setText("Plane added: " + addedPlane.toString() );

    }

    private PlaneModelData setModel(){
        String pickedModelString = modelDropDown.getSelectionModel().getSelectedItem().toString();
        String[] splitString = pickedModelString.split(" ");
        String manufacturer = splitString[0];
        String modelNumber = splitString[1];
        PlaneModelData pickedModel = null;
        for (PlaneModelData planeModel: planeModelList) {
            if (planeModel.getManufacturer().equals(manufacturer) && planeModel.getModelNumber().equals(modelNumber)){
                pickedModel = planeModel;
                break;
            }
        }


        return pickedModel;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (PlaneModelData planeModelData : planeModelList) {
            modelDropDown.getItems().addAll(planeModelData.getManufacturer() + " " + planeModelData.getModelNumber());
        }
        modelDropDown.getSelectionModel().select(0);
    }

}

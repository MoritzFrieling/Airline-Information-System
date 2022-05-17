package gui;

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

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final PlaneManager planeManager;

    public AddPlaneController(Supplier<SceneManager> sceneManagerSupplier, PlaneManager planeManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planeManager = planeManager;
    }

    @FXML
    private void toSecondary() {

        sceneManagerSupplier.get().changeScene("secondary");
    }

    @FXML
    private void storePlane() throws Exception {

        PlaneData planeData = new PlaneData(setModel(), Integer.parseInt(economySeats.getText()), Integer.parseInt(businessSeats.getText()), Integer.parseInt(firstClassSeats.getText()));

        PlaneData addedPlane = planeManager.add(planeData);

        result.setText("Plane added: " + addedPlane.toString() );

    }

    private PlaneModelData setModel(){
        if (modelDropDown.getSelectionModel().isSelected(0)){
            return new PlaneModelData("Boeing","737",230,7000,35000, 900);
        }else if (modelDropDown.getSelectionModel().isSelected(1)){
            return new PlaneModelData("Boeing","747",350,8000,40000, 1000);
        }else if (modelDropDown.getSelectionModel().isSelected(2)){
            return new PlaneModelData("Boeing","757",230,7000,35000, 950);
        }else return null;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelDropDown.getItems().addAll("Boeing-737","Boeing-747","Boeing-757");
        modelDropDown.getSelectionModel().select("Boeing-737");
    }

}

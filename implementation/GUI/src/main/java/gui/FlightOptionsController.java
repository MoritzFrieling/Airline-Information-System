package gui;

import businesslogic.FlightManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Supplier;

public class FlightOptionsController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    public Label errorNotImplemented;


    public FlightOptionsController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    //over the button "back"
    @FXML
    private void toSecondary() {
        sceneManagerSupplier.get().changeScene("secondary");
    }

    //over the button "Register Flight"
    @FXML
    public void toAddFlight() {
        sceneManagerSupplier.get().changeScene("addFlightView");
    }

    //over the button "Edit Flight"
    @FXML
    private void toEditFlight() {
        errorNotImplemented.setText("Not yet implemented!");
        //sceneManagerSupplier.get().changeScene("editFlightView");

    }

    //over the button "Delete Flight"
    @FXML
    private void toDeleteFlight() {
        errorNotImplemented.setText("Not yet implemented!");
        //sceneManagerSupplier.get().changeScene("deleteFlightView");

    }

    //over the button "Lookup upcoming Flights"
    @FXML
    private void toLookupFlights() {
        errorNotImplemented.setText("Not implemented yet!");
        //sceneManagerSupplier.get().changeScene("lookupFlightsView");

    }




}
